package io.lastwill.eventscan.model;

import lombok.Getter;

@Getter
public enum CryptoCurrency {
    DUCX(18),
    DUC(8),
    USD(6, "$");

    private final int decimals;
    private final String symbol;

    CryptoCurrency(int decimals, String symbol) {
        this.decimals = decimals;
        this.symbol = symbol;
    }

    CryptoCurrency(int decimals) {
        this(decimals, null);
    }

    @Override
    public String toString() {
        return symbol != null
                ? symbol
                : super.toString();
    }
}
