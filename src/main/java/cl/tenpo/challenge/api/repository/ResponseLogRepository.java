package cl.tenpo.challenge.api.repository;

import cl.tenpo.challenge.api.repository.constant.Statement;
import cl.tenpo.challenge.api.repository.model.ResponseLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseLogRepository extends JpaRepository<ResponseLog, Long> {
    @Query(value = Statement.RESPONSE_LOG_SEARCH_STATEMENT + "", nativeQuery = true)
    String findLastResponseByMethodAndPath(String method, String path);
}
