package io.lastwill.eventscan.services.handlers;

import io.lastwill.eventscan.events.model.UserPaymentEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserPaymentEventHandler {

    @EventListener
    private void userPaymentEventHandler(final UserPaymentEvent event) {
  //пишем в базу
    }
}
