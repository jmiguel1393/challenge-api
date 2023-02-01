package cl.tenpo.challenge.api.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "request_logs")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RequestLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;
    private String method;
    private String path;
    private String parameters;
    private String headers;
    private String body;

    private LocalDateTime createdAt;
}
