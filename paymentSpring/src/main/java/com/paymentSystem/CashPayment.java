package com.paymentSystem;



import org.springframework.stereotype.Component;

@Component
public class CashPayment implements Payment {

    @Override
    public PaymentReceipt pay(PaymentRequest request) {

        return new PaymentReceipt(
                request.getTransactionId(),
                PaymentStatus.SUCCESS,
                "Cash received successfully"
        );
    }
}
