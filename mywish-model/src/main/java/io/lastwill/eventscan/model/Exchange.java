package io.lastwill.eventscan.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "exchange")
@Getter
public class Exchange {
    @Id
    private long id;

    @Column(name = "from_address")
    private String fromAdress;

    @Column(name = "to_address")
    private String toAddress;

    @Column(name = "amount")
    private BigInteger amount;

    @Column(name = "from_curr")
    private CryptoCurrency fromCurrency;

    @Column(name = "to_curr")
    private CryptoCurrency toCurrency;

    @Column(name = "tx_hash")
    private String txHash;

    @Column(name = "status")
    private TransactionStatus status;
}
