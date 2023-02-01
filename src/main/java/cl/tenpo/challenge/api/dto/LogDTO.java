package cl.tenpo.challenge.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LogDTO {
    private String method;
    private String path;
    private String parameters;
    private TransactionDTO request;
    private TransactionDTO response;
}
