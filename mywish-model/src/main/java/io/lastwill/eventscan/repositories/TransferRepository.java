package io.lastwill.eventscan.repositories;

import io.lastwill.eventscan.model.TransactionStatus;
import io.lastwill.eventscan.model.Transfer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

public interface TransferRepository extends CrudRepository<Transfer, Long> {
    @Query("select c from Transfer c where c.status in :status")
    List<Transfer> findByStatus(@Param("status") TransactionStatus status);

    @Query("select c from Transfer c where c.exchangeId in :exchangeId")
    List<Transfer> findByExchangeId(@Param("exchangeId") Collection<Long> exchangeId);
}
