package io.lastwill.eventscan.model;

import lombok.Getter;


@Getter
public enum Status {
    DONE,
    ERROR,
    OK,
    WAITING_FOR_CONFIRMATION,
    OVERPAID,
    INSUFFICIENT,
}
