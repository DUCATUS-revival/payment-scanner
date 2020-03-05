package io.lastwill.eventscan.events.model;

import io.mywish.blockchain.WrapperTransaction;
import io.lastwill.eventscan.model.NetworkType;
import lombok.Getter;
import java.math.BigInteger;

@Getter
public class UserPaymentEvent extends BaseEvent {
    private final WrapperTransaction transaction;
    private final BigInteger amount;
    private final String address;
    private final boolean isSuccess;

    public UserPaymentEvent(NetworkType networkType,
                            WrapperTransaction transaction,
                            BigInteger amount,
                            String address,
                            boolean isSuccess) {
        super(networkType);
        this.transaction = transaction;
        this.amount = amount;
        this.address = address;
        this.isSuccess = isSuccess;
    }
}
