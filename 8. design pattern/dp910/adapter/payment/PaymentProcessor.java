package main.dp910.adapter.payment;

public interface PaymentProcessor {

    void pay(String account, double amount);
}
