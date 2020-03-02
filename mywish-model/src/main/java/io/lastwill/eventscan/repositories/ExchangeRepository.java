package io.lastwill.eventscan.repositories;

import io.lastwill.eventscan.model.Exchange;
import io.lastwill.eventscan.model.TransactionStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExchangeRepository extends CrudRepository<Exchange, Long> {
    List<Exchange> findAllByStatus(@Param("status") TransactionStatus status);
}
