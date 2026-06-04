package main.dp910.adapter.payment.impl;

import main.dp910.adapter.payment.PaymentProcessor;

public class CreditCardPayment implements PaymentProcessor {

    @Override
    public void pay(String account, double amount) {
        System.out.println(
                "Processing Credit Card payment for "
                        + account
                        + " amount "
                        + amount
        );
    }
}