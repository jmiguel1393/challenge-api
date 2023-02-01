package cl.tenpo.challenge.api.util;

import cl.tenpo.challenge.api.dto.CalculationDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonUtilTest {
    @Test
    void shouldConvertObjectToJsonString() {
        assertEquals("{\"percentage\":11.0}", JsonUtil.objectToJson(CalculationDto.builder().percentage(11.0).build()));
    }
}
