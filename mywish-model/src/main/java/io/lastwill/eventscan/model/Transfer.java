package io.lastwill.eventscan.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "transfer")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Transfer {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "exchange_id", referencedColumnName = "id")
    private Exchange exchangeId;

    @Column(name = "tx_hash")
    private String txHash;

    @Column(name = "amount")
    private BigInteger amount;

    @Column(name = "status")
    private TransactionStatus status;

}
