package cl.tenpo.challenge.api.rest.controller;

import cl.tenpo.challenge.api.dto.CalculationDto;
import cl.tenpo.challenge.api.service.CalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalculationController {
    private final CalculationService calculationService;

    @GetMapping("/calculations/percentages")
    public ResponseEntity<CalculationDto> calculatePercentage(
            @RequestParam(name = "firstValue") Integer firstValue,
            @RequestParam(name = "secondValue") Integer secondValue) {
        CalculationDto calculationDto = calculationService.calculatePercentage(firstValue, secondValue);
        if (calculationDto != null) {
            return new ResponseEntity<>(calculationDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
