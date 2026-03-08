package com.paymentSystem;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DebitPayment implements Payment {

    @Override
    public PaymentReceipt pay(PaymentRequest request) {

        if (request.getAmount() > 50000) {
            return new PaymentReceipt(
                    request.getTransactionId(),
                    PaymentStatus.FAILED,
                    "Debit card limit exceeded"
            );
        }

        return new PaymentReceipt(
                request.getTransactionId(),
                PaymentStatus.SUCCESS,
                "Debit card payment successful"
        );
    }
}