package main.project908.model;

import java.util.ArrayList;
import java.util.List;

public class EWalletSystem {

    private final static String name = "E Wallet System";

    private List<Account> accounts = new ArrayList<>();

    public static String getName() {
        return name;
    }


    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
