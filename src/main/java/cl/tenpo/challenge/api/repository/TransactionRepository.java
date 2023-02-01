package cl.tenpo.challenge.api.repository;

import cl.tenpo.challenge.api.repository.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
