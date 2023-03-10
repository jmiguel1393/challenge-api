package cl.tenpo.challenge.api.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "response_logs")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ResponseLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String method;
    private String path;
    private String uuid;
    private String headers;

    @Column(columnDefinition = "text")
    private String body;

    private LocalDateTime createdAt;

}
