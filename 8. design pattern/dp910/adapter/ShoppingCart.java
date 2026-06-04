package main.dp910.adapter;

import main.dp910.adapter.payment.PaymentProcessor;

public class ShoppingCart {

    private PaymentProcessor paymentProcessor;

    public ShoppingCart(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout(String account, double amount){
        paymentProcessor.pay(account, amount);
    }
}
