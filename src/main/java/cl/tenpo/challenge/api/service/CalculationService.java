package cl.tenpo.challenge.api.service;

import cl.tenpo.challenge.api.client.ApiClient;
import cl.tenpo.challenge.api.dto.CalculationDTO;
import cl.tenpo.challenge.api.util.DataUtil;
import cl.tenpo.challenge.api.util.JsonUtil;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculationService {
    private final ApiClient apiClient;
    private final LogService logService;

    @CircuitBreaker(name = "percentageapicalls", fallbackMethod = "getLastPercentage")
    public CalculationDTO calculatePercentage(Integer firstNumber, Integer secondNumber) {
        Integer percentage = apiClient.getPercentage(firstNumber, secondNumber);
        Integer sum = DataUtil.calculateSum(firstNumber, secondNumber);
        Double percentageApplied = DataUtil.applyPercentage(sum, percentage);
        return CalculationDTO.builder().percentage(percentageApplied).build();
    }

    public CalculationDTO getLastPercentage(Integer firstNumber, Integer secondNumber, Exception e) {
        String responseBody = logService.getLastPercentageResponse();
        return JsonUtil.jsonBodyToCalculation(responseBody);
    }
}
