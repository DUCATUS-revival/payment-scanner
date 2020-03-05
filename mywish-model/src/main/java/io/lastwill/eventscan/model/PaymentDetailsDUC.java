package io.lastwill.eventscan.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Setter
@Table(name = "payment_details_duc")
@Getter
public class PaymentDetailsDUC {
    @Id
    private int id;
    @Column(name = "rx_address")
    private String rxAddress;
    @Column(name = "amount")
    private BigInteger amount;
    @Column(name = "rx_amount")
    private BigInteger rxAmount;
    @Column(name = "shop")
    private String shop;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;


public PaymentDetailsDUC() {}
}
