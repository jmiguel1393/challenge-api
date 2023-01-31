package cl.tenpo.challenge.api.service;

import cl.tenpo.challenge.api.client.TenpoClient;
import cl.tenpo.challenge.api.util.DataUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculationService {
    private final TenpoClient tenpoClient;

    public Double applyCalculation(Integer firstNumber, Integer secondNumber) {
        Integer percentage = tenpoClient.getPercentage(firstNumber, secondNumber);
        Integer sum = DataUtil.calculateSum(firstNumber, secondNumber);
        return DataUtil.applyPercentage(sum, percentage);
    }
}
