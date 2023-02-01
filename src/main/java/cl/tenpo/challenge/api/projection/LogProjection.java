package cl.tenpo.challenge.api.projection;

import java.time.LocalDateTime;

public interface LogProjection {
    String getMethod();

    String getPath();

    String getParameters();

    String getRequestBody();

    LocalDateTime getRequestDate();

    String getRequestHeaders();

    String getResponseBody();

    LocalDateTime getResponseDate();

    String getResponseHeaders();

    void setRequestDate(LocalDateTime requestDate);

    void setResponseDate(LocalDateTime responseDate);
}
