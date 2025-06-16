package main.eWalletSystem906.model;

import java.util.ArrayList;
import java.util.List;

public class EWallet {

    private final String name = "EraaSoft EWallet";

    private List<Account> accounts = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
