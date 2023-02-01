package cl.tenpo.challenge.api.service;

import cl.tenpo.challenge.api.client.TenpoClient;
import cl.tenpo.challenge.api.dto.CalculationDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculationServiceTest {
    @Mock
    TenpoClient tenpoClient;

    @Test
    void shouldCalculatePercentageBetweenTwoNumbersAndReturnAnIntegerNumber() {
        when(tenpoClient.getPercentage(5, 5)).thenReturn(10);
        CalculationService calculationService = new CalculationService(tenpoClient);
        CalculationDTO calculation = calculationService.calculatePercentage(5, 5);
        assertEquals(11, calculation.getPercentage());
    }

    @Test
    void shouldCalculatePercentageBetweenTwoNumbersAndReturnAnDecimalNumber() {
        when(tenpoClient.getPercentage(6, 6)).thenReturn(12);
        CalculationService calculationService = new CalculationService(tenpoClient);
        CalculationDTO calculation = calculationService.calculatePercentage(6, 6);
        assertEquals(13.44, calculation.getPercentage());
    }
}
