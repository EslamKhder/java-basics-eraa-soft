package main.g911.ewalletsystem.model;

import java.util.ArrayList;
import java.util.List;

public class EWalletSystem {

    private final String name = "EraaSoft Wallet";

    private List<Account> accounts = new ArrayList<>(); // [, , , , , ,]

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
