package main.dp910.adapter.old;

import main.dp910.adapter.payment.PaymentProcessor;

public class PaymentAdapter implements PaymentProcessor {

    private OldPaymentSystem oldPaymentSystem;

    public PaymentAdapter(OldPaymentSystem oldPaymentSystem) {
        this.oldPaymentSystem = oldPaymentSystem;
    }


    @Override
    public void pay(String account, double amount) {
        oldPaymentSystem.makePayment(account, amount);
    }
}
