package cl.tenpo.challenge.api.util;

import cl.tenpo.challenge.api.dto.CalculationDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    public static String objectToJson(Object object) {
        String json = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static CalculationDTO jsonBodyToCalculation(String body) {
        CalculationDTO calculationDTO = null;
        try {
            calculationDTO = new ObjectMapper().readValue(body, CalculationDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return calculationDTO;
    }
}
