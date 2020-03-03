package io.lastwill.eventscan.messages;

import io.lastwill.eventscan.model.CryptoCurrency;
import lombok.Getter;
import lombok.ToString;

import java.math.BigInteger;

@ToString(callSuper = true)
@Getter
public class PaymentNotify extends BaseNotify {
    private final BigInteger amount;
    private final CryptoCurrency currency;
    private final boolean isSuccess;

    public PaymentNotify( BigInteger amount, PaymentStatus status, String txHash, CryptoCurrency currency, boolean isSuccess) {
        super(status, txHash);
        this.amount = amount;
        this.currency = currency;
        this.isSuccess = isSuccess;
    }

    @Override
    public String getType() {
        return "payment";
    }
}
