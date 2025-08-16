package main.ewallet907.service;

import main.ewallet907.model.Account;

public interface AccountService {

    boolean createAccount(Account account);

    Account getAccount(Account account);
    boolean deposit(Account account, double mount);
    boolean withdraw(Account account, double mount);
    boolean transfer(Account account, String userName, double mount);
}
