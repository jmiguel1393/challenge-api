package cl.tenpo.challenge.api.rest.controller;

import cl.tenpo.challenge.api.dto.LogDTO;
import cl.tenpo.challenge.api.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequiredArgsConstructor
@ApiIgnore
public class LogController {
    private final LogService logService;

    @GetMapping("/logs")
    public ResponseEntity<List<LogDTO>> getLogs(@RequestParam(defaultValue = "5", required = false)
                                                        Integer pageSize,
                                                @RequestParam(defaultValue = "0", required = false)
                                                        Integer page) {
        Pageable pageable = PageRequest.of(page, pageSize);
        List<LogDTO> logs = logService.getAllLogs(pageable);
        return new ResponseEntity<>(logs, HttpStatus.ACCEPTED);
    }
}
