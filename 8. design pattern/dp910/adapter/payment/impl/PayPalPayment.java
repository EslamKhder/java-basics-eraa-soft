package main.dp910.adapter.payment.impl;

import main.dp910.adapter.payment.PaymentProcessor;

public class PayPalPayment implements PaymentProcessor {

    @Override
    public void pay(String account, double amount) {
        System.out.println(
                "Processing PayPal payment for user "
                        + account
                        + " with amount "
                        + amount
        );
    }
}