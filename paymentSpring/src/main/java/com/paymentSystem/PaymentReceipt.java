package com.paymentSystem;


public class PaymentReceipt {

    private String transactionId;
    private PaymentStatus status;
    private String message;

    public PaymentReceipt(String transactionId,
                          PaymentStatus status,
                          String message) {
        this.transactionId = transactionId;
        this.status = status;
        this.message = message;
    }

    @Override
    public String toString() {
        return "PaymentReceipt{" +
                "transactionId='" + transactionId + '\'' +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
