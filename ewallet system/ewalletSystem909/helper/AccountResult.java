package main.ewalletSystem.helper;

public class AccountResult {

    private Integer error;

    private double amount;

    public AccountResult() {
    }

    public AccountResult(Integer error) {
        this.error = error;
    }

    public AccountResult(Integer error, double amount) {
        this.error = error;
        this.amount = amount;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
