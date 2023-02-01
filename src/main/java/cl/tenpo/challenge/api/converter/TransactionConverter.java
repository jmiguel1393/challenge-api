package cl.tenpo.challenge.api.converter;

import cl.tenpo.challenge.api.repository.model.Transaction;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.function.Function;

@Component
public class TransactionConverter implements Function<HttpServletRequest, Transaction> {
    @Override
    public Transaction apply(HttpServletRequest request) {
        return Transaction.builder()
                .method(request.getMethod())
                .path(request.getRequestURI())
                .requestHeaders(Collections.list(request.getHeaders("")).toString())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
