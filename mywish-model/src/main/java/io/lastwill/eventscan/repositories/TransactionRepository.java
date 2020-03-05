package io.lastwill.eventscan.repositories;

import io.lastwill.eventscan.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    boolean existsByTxHash(@Param("tx_hash") String hash);
}
