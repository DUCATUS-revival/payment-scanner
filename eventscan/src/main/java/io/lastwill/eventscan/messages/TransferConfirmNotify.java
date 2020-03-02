package io.lastwill.eventscan.messages;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class TransferConfirmNotify extends BaseNotify {
    private final long transferId;
    private final boolean isSuccess;

    public TransferConfirmNotify(String txHash, long transferId, boolean isSuccess) {
        super(PaymentStatus.COMMITTED, txHash);
        this.transferId = transferId;
        this.isSuccess = isSuccess;
    }

    @Override
    public String getType() {
        return "transferred";
    }
}
