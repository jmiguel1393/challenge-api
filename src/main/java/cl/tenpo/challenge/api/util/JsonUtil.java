package cl.tenpo.challenge.api.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    public static String objectToJson(Object object) {
        String json = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            //e.printStackTrace();
        }
        return json;
    }
}
