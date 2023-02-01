package cl.tenpo.challenge.api.service;

import cl.tenpo.challenge.api.dto.LogDTO;
import cl.tenpo.challenge.api.dto.TransactionDTO;
import cl.tenpo.challenge.api.projection.LogProjection;
import cl.tenpo.challenge.api.repository.RequestLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LogService {
    private final RequestLogRepository requestLogRepository;

    public List<LogDTO> getAllLogs(Pageable pageable) {
        Iterable<LogProjection> logs =
                requestLogRepository.findAllWithPagination(pageable);
        List<LogDTO> logsDTO = new ArrayList<>();
        logs.forEach(log -> logsDTO.add(buildLogDTO(log)));
        return logsDTO;
    }

    private LogDTO buildLogDTO(LogProjection log) {
        return LogDTO.builder()
                .method(log.getMethod())
                .parameters(log.getParameters())
                .path(log.getPath())
                .request(buildTransactionDTO(log.getRequestBody(), log.getRequestHeaders(), log.getRequestDate()))
                .response(buildTransactionDTO(log.getResponseBody(), log.getResponseHeaders(), log.getResponseDate()))
                .build();
    }

    private TransactionDTO buildTransactionDTO(String body, String headers, LocalDateTime date) {
        return TransactionDTO.builder()
                .body(body)
                .headers(headers)
                .date(date.format(DateTimeFormatter.ISO_DATE_TIME))
                .build();
    }
}
