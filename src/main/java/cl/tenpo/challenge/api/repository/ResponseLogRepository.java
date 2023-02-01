package cl.tenpo.challenge.api.repository;

import cl.tenpo.challenge.api.repository.model.ResponseLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseLogRepository extends JpaRepository<ResponseLog, Long> {
}
