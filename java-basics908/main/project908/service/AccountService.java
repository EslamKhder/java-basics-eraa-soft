package main.project908.service;

import main.project908.model.Account;

public interface AccountService {
    boolean createAccount(Account account);
    Account getAccount(Account account);

    boolean deposit(Account account, double amount);
    boolean withdraw(Account account, double amount);
    boolean transfer(Account account, String userNameTransfer, double amount);
}
