package main.dp910.adapter.payment.impl;

import main.dp910.adapter.payment.PaymentProcessor;

public class BankTransferPayment implements PaymentProcessor {

    @Override
    public void pay(String account, double amount) {
        System.out.println(
                "Processing Bank Transfer for account "
                        + account
                        + " amount "
                        + amount
        );
    }
}