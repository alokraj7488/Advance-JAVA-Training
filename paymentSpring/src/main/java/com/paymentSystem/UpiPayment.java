package com.paymentSystem;


import org.springframework.stereotype.Component;

@Component
public class UpiPayment implements Payment {

    @Override
    public PaymentReceipt pay(PaymentRequest request) {

        if (request.getAmount() <= 0) {
            return new PaymentReceipt(
                    request.getTransactionId(),
                    PaymentStatus.FAILED,
                    "Invalid amount"
            );
        }

        return new PaymentReceipt(
                request.getTransactionId(),
                PaymentStatus.SUCCESS,
                "UPI payment successful"
        );
    }
}