package cl.tenpo.challenge.api.converter;

import cl.tenpo.challenge.api.constant.SessionAttribute;
import cl.tenpo.challenge.api.repository.model.RequestLog;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.function.Function;

@Component
public class RequestLogConverter implements Function<HttpServletRequest, RequestLog> {
    @Override
    public RequestLog apply(HttpServletRequest request) {
        return RequestLog.builder()
                .headers(Collections.list(request.getHeaders("")).toString())
                .method(request.getMethod())
                .path(request.getRequestURI())
                .uuid((String) request.getSession().getAttribute(SessionAttribute.TRANSACTION_ID))
                .createdAt(LocalDateTime.now())
                .build();
    }
}
