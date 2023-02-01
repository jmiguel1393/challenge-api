package cl.tenpo.challenge.api.rest.controller;

import cl.tenpo.challenge.api.dto.CalculationDTO;
import cl.tenpo.challenge.api.service.CalculationService;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
@Api(tags = "Calculations", description = "Calculation of operations between two values")
public class CalculationController {
    private final CalculationService calculationService;
    private final Bucket bucket = Bucket4j.builder()
            .addLimit(Bandwidth.classic(3, Refill.greedy(3, Duration.ofMinutes(1))))
            .build();


    @GetMapping("/calculations/percentages")
    @ApiOperation(value = "Calculation of percentages")
    public ResponseEntity<CalculationDTO> calculatePercentage(
            @RequestParam(name = "firstValue") Integer firstValue,
            @RequestParam(name = "secondValue") Integer secondValue) {
        if (bucket.tryConsume(1)) {
            CalculationDTO calculationDto = calculationService.calculatePercentage(firstValue, secondValue);
            if (calculationDto != null) {
                return new ResponseEntity<>(calculationDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
    }
}
