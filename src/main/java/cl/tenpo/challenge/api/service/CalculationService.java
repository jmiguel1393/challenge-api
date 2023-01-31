package cl.tenpo.challenge.api.service;

import cl.tenpo.challenge.api.client.TenpoClient;
import cl.tenpo.challenge.api.dto.CalculationDto;
import cl.tenpo.challenge.api.util.DataUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculationService {
    private final TenpoClient tenpoClient;

    public CalculationDto calculatePercentage(Integer firstNumber, Integer secondNumber) {
        Integer percentage = tenpoClient.getPercentage(firstNumber, secondNumber);
        if (percentage != null) {
            Integer sum = DataUtil.calculateSum(firstNumber, secondNumber);
            Double percentageApplied = DataUtil.applyPercentage(sum, percentage);
            return CalculationDto.builder().percentage(percentageApplied).build();
        }
        return null;
    }
}