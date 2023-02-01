package cl.tenpo.challenge.api.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String method;
    private String path;
    private String parameters;
    private String requestHeaders;
    private String requestBody;

    private String responseHeaders;
    private String responseBody;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
