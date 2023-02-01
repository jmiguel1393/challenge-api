package cl.tenpo.challenge.api.service;

import cl.tenpo.challenge.api.constant.SessionAttribute;
import cl.tenpo.challenge.api.repository.RequestLogRepository;
import cl.tenpo.challenge.api.repository.ResponseLogRepository;
import cl.tenpo.challenge.api.repository.model.RequestLog;
import cl.tenpo.challenge.api.repository.model.ResponseLog;
import cl.tenpo.challenge.api.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class LoggingService {
    private final RequestLogRepository requestLogRepository;
    private final ResponseLogRepository responseLogRepository;
    private final Function<HttpServletRequest, RequestLog> requestLogConverter;

    public void logRequest(HttpServletRequest request, Object body) {
        request.getSession().setAttribute(SessionAttribute.TRANSACTION_ID, UUID.randomUUID().toString());
        saveRequest(request, body);
    }

    @Async
    void saveRequest(HttpServletRequest request, Object body) {
        Map<String, String> parameters = getParameters(request);
        RequestLog requestLog = requestLogConverter.apply(request);
        if (!parameters.isEmpty()) {
            requestLog.setParameters(parameters.toString());
        }
        if (!Objects.isNull(body)) {
            requestLog.setBody(JsonUtil.objectToJson(body));
        }
        requestLogRepository.save(requestLog);
    }

    @Async
    public void logResponse(HttpServletRequest request, HttpServletResponse response, Object body) {
        ResponseLog responseLog = buildResponseLog(request, body);
        Map<String, String> headers = getHeaders(response);
        if (!headers.isEmpty()) {
            responseLog.setHeaders(headers.toString());
        }
        responseLogRepository.save(responseLog);
    }

    private ResponseLog buildResponseLog(HttpServletRequest request, Object body) {
        return ResponseLog.builder()
                .uuid((String) request.getSession().getAttribute(SessionAttribute.TRANSACTION_ID))
                .body(JsonUtil.objectToJson(body))
                .method(request.getMethod())
                .path(request.getRequestURI())
                .createdAt(LocalDateTime.now())
                .build();
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
