package cl.tenpo.challenge.api.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataUtilTest {
    @Test
    void shouldCalculateTheSumOfTwoNumbers() {
        assertEquals(10, DataUtil.calculateSum(5, 5));
    }

    @Test
    void shouldApplyPercentageToSum() {
        assertEquals(11, DataUtil.applyPercentage(10, 10));
    }
}
