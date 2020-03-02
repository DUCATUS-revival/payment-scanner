package io.lastwill.eventscan.events.model;

import io.lastwill.eventscan.model.NetworkType;
import lombok.Getter;

@Getter
public class TransferConfirmEvent extends BaseEvent {
    private final String txHash;
    private final long transferId;
    private final String type = "transferred";
    private final boolean isSuccess;

    public TransferConfirmEvent(NetworkType networkType, Long transferId, String txHash, boolean isSuccess) {
        super(networkType);
        this.txHash = txHash;
        this.transferId = transferId;
        this.isSuccess = isSuccess;
    }

}
