package cl.tenpo.challenge.api.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class ApiClient {

    @Value("${config.api.url}")
    private String url;

    public Integer getPercentage(Integer firstNumber, Integer secondNumber) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(
                buildUrl(url, firstNumber, secondNumber), Integer.class);
    }

    private String buildUrl(String url, Integer firstNumber, Integer secondNumber) {
        return UriComponentsBuilder
                .fromUriString(url.concat("/percentages"))
                .queryParam("firstNumber", firstNumber)
                .queryParam("secondNumber", secondNumber)
                .build().toUriString();
    }
}
