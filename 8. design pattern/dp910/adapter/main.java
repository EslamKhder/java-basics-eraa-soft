package main.dp910.adapter;


import main.dp910.adapter.old.OldPaymentSystem;
import main.dp910.adapter.old.PaymentAdapter;
import main.dp910.adapter.payment.impl.BankTransferPayment;
import main.dp910.adapter.payment.impl.CreditCardPayment;
import main.dp910.adapter.payment.impl.PayPalPayment;
import main.dp910.adapter.payment.impl.XPayment;

public class main {
    public static void main(String[] args) {

        ShoppingCart shoppingCartBankTransfer = new ShoppingCart(new BankTransferPayment());
        shoppingCartBankTransfer.checkout("acc1", 100);

        ShoppingCart shoppingCartPayPal = new ShoppingCart(new PayPalPayment());
        shoppingCartPayPal.checkout("acc1", 100);

        ShoppingCart shoppingCreditCard = new ShoppingCart(new CreditCardPayment());
        shoppingCreditCard.checkout("acc1", 100);

        ShoppingCart shoppingXPayment = new ShoppingCart(new XPayment());
        shoppingXPayment.checkout("acc1", 100);

        PaymentAdapter paymentAdapter = new PaymentAdapter(new OldPaymentSystem());
        ShoppingCart oldPayment = new ShoppingCart(paymentAdapter);
        oldPayment.checkout("acc1", 100);
    }

}
