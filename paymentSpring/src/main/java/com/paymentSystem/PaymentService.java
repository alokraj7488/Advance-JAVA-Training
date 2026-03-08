package com.paymentSystem;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final Payment payment;

    public PaymentService(@Qualifier("upiPayment") Payment payment) {
        this.payment = payment;
    }

    public void makePayment(double amount) {

        PaymentRequest request =
                new PaymentRequest(amount, Currency.INR);

        PaymentReceipt receipt = payment.pay(request);

        System.out.println(receipt);
    }
}
