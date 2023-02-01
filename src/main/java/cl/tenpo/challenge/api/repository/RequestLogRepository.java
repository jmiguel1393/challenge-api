package cl.tenpo.challenge.api.repository;

import cl.tenpo.challenge.api.projection.LogProjection;
import cl.tenpo.challenge.api.repository.constant.Statement;
import cl.tenpo.challenge.api.repository.model.RequestLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RequestLogRepository extends JpaRepository<RequestLog, Long> {
    @Query(value = Statement.LOG_SEARCH_STATEMENT, nativeQuery = true)
    Page<LogProjection> findAllWithPagination(Pageable pageable);
}
