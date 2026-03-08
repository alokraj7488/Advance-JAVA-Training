package com.paymentSystem;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentRequest {

    private String transactionId;
    private double amount;
    private Currency currency;
    private LocalDateTime timestamp;

    public PaymentRequest(double amount, Currency currency) {
        this.transactionId = UUID.randomUUID().toString();
        this.amount = amount;
        this.currency = currency;
        this.timestamp = LocalDateTime.now();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
