package io.lastwill.eventscan.services.handlers;

import io.lastwill.eventscan.events.model.UserPaymentEvent;
import io.lastwill.eventscan.model.PaymentDetailsDUC;
import io.lastwill.eventscan.model.Status;
import io.lastwill.eventscan.model.Transaction;
import io.lastwill.eventscan.repositories.PaymentDucRepository;
import io.lastwill.eventscan.repositories.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserPaymentEventHandler {
    @Autowired
    private PaymentDucRepository paymentDucRepository;
    @Autowired
    private TransactionRepository transactionRepository;


    @EventListener
    private void userPaymentEventHandler(final UserPaymentEvent event) {
        String txHash = event.getTransaction().getHash();
        if (transactionRepository.existsByTxHash(txHash)) {
            return;
        }
        PaymentDetailsDUC paymentDetails = paymentDucRepository.findFirstByRxAddress(event.getAddress());
        Transaction transaction = new Transaction(paymentDetails, event.getAmount());

        paymentDucRepository.updateRxAmount(paymentDetails.getRxAddress(),
                paymentDetails.getRxAmount().add(transaction.getAmount()));

        if (paymentDetails.getRxAmount().compareTo(paymentDetails.getAmount()) > 0) {
            paymentDetails.setStatus(Status.OVERPAID);
        }

        if (paymentDetails.getRxAmount().compareTo(paymentDetails.getAmount()) == 0) {
            paymentDetails.setStatus(Status.OK);
        }

        if (paymentDetails.getRxAmount().compareTo(paymentDetails.getAmount()) < 0) {
            paymentDetails.setStatus(Status.INSUFFICIENT);
        }
        paymentDucRepository.save(paymentDetails);
    }
}
