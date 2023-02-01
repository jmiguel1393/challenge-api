package cl.tenpo.challenge.api.service;

import cl.tenpo.challenge.api.repository.TransactionRepository;
import cl.tenpo.challenge.api.repository.model.Transaction;
import cl.tenpo.challenge.api.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class LoggingService {
    private final TransactionRepository transactionRepository;

    public void logRequest(HttpServletRequest request, Object body) {
        Map<String, String> parameters = getParameters(request);
        Transaction transaction = Transaction.builder()
                .method(request.getMethod())
                .path(request.getRequestURI())
                .requestHeaders(Collections.list(request.getHeaders("")).toString())
                .createdAt(LocalDateTime.now())
                .build();
        if (!parameters.isEmpty()) {
            transaction.setParameters(parameters.toString());
        }
        if (!Objects.isNull(body)) {
            transaction.setRequestBody(JsonUtil.objectToJson(body));
        }
        transactionRepository.save(transaction);
        if (transaction.getId() != null) {
            request.getSession().setAttribute("trx_id", transaction.getId());
        }
    }

    public void logResponse(HttpServletRequest request, HttpServletResponse response, Object body) {
        Transaction transaction = transactionRepository.findById((Long) request.getSession().getAttribute("trx_id")).orElse(Transaction.builder().build());
        Map<String, String> headers = getHeaders(response);
        if (!headers.isEmpty()) {
            transaction.setResponseHeaders(headers.toString());
        }
        transaction.setResponseBody(JsonUtil.objectToJson(body));
        transaction.setUpdatedAt(LocalDateTime.now());
        transactionRepository.save(transaction);
    }


    private Map<String, String> getParameters(HttpServletRequest request) {
        Map<String, String> parameters = new HashMap<>();
        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String paramName = params.nextElement();
            parameters.put(paramName, request.getParameter(paramName));
        }
        return parameters;
    }

    private Map<String, String> getHeaders(HttpServletResponse response) {
        Map<String, String> headers = new HashMap<>();
        response.getHeaderNames().forEach(h -> headers.put(h, response.getHeader(h)));
        return headers;
    }


}
