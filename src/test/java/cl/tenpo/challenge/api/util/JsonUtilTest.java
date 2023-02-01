package cl.tenpo.challenge.api.util;

import cl.tenpo.challenge.api.dto.CalculationDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonUtilTest {
    @Test
    void shouldConvertObjectToJsonString() {
        assertEquals("{\"percentage\":11.0}", JsonUtil.objectToJson(CalculationDTO.builder().percentage(11.0).build()));
    }
}
