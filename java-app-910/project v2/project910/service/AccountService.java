package main.project910.service;

import main.project910.model.Account;

public interface AccountService {

    Account createAccount(Account account);

    Account getAccountByUserNameAndPassword(Account account);

    Account deposit(Account account, double amount);
    Account withdraw(Account account, double amount);
}
