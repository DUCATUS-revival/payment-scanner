package io.lastwill.eventscan.model;

import lombok.Getter;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "transaction")
@Getter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private PaymentDetailsDUC paymentDetailsDUC;

    @Column(name = "tx_hash")
    private String txHash;

    @Column(name = "amount")
    private BigInteger amount;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public Transaction(PaymentDetailsDUC paymentDetailsDUC, BigInteger amount) {
        this.paymentDetailsDUC = paymentDetailsDUC;
        this.amount = amount;
    }

}
