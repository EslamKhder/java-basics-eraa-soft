package main.dp910.adapter.payment.impl;

import main.dp910.adapter.payment.PaymentProcessor;

public class XPayment implements PaymentProcessor {
    @Override
    public void pay(String account, double amount) {
        System.out.println(
                "Processing X payment for "
                        + account
                        + " amount "
                        + amount
        );
    }
}
