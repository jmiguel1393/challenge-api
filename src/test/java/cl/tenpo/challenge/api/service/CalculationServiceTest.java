package cl.tenpo.challenge.api.service;

import cl.tenpo.challenge.api.client.TenpoClient;
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
    void shouldApplyCalculationBetweenTwoNumbersAndReturnAnIntegerNumber() {
        when(tenpoClient.getPercentage(5, 5)).thenReturn(10);
        CalculationService calculationService = new CalculationService(tenpoClient);
        assertEquals(11, calculationService.applyCalculation(5, 5));
    }

    @Test
    void shouldApplyCalculationBetweenTwoNumbersAndReturnAnDecimalNumber() {
        when(tenpoClient.getPercentage(6, 6)).thenReturn(12);
        CalculationService calculationService = new CalculationService(tenpoClient);
        assertEquals(13.44, calculationService.applyCalculation(6, 6));
    }
}
