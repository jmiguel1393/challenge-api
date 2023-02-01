package cl.tenpo.challenge.api.service;

import cl.tenpo.challenge.api.dto.LogDTO;
import cl.tenpo.challenge.api.projection.LogProjection;
import cl.tenpo.challenge.api.repository.RequestLogRepository;
import cl.tenpo.challenge.api.repository.ResponseLogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LogServiceTest {
    @Mock
    RequestLogRepository requestLogRepository;

    @Mock
    ResponseLogRepository responseLogRepository;

    @Test
    void shouldFindAllLogsPaginated() {
        ProjectionFactory factory = new SpelAwareProxyProjectionFactory();
        LogProjection logProjection = factory.createProjection(LogProjection.class);
        logProjection.setRequestDate(LocalDateTime.now());
        logProjection.setResponseDate(LocalDateTime.now());
        Pageable pageable = PageRequest.of(0, 5);
        List<LogProjection> logs = new ArrayList<>();
        logs.add(logProjection);
        when(requestLogRepository.findAllWithPagination(pageable)).thenReturn(new PageImpl(logs));
        LogService logService = new LogService(requestLogRepository, responseLogRepository);
        List<LogDTO> logsDTO = logService.getAllLogs(pageable);
        assertEquals(1, logsDTO.size());
    }
}
