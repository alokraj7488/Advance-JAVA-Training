package com.paymentSystem;

import org.springframework.stereotype.Component;

@Component
public class AtmPayment implements Payment {

    @Override
    public PaymentReceipt pay(PaymentRequest request) {

        return new PaymentReceipt(
                request.getTransactionId(),
                PaymentStatus.PENDING,
                "ATM processing, please wait"
        );
    }
}
