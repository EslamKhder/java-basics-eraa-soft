package main.ewalletSystem.service;

import main.ewalletSystem.helper.AccountResult;
import main.ewalletSystem.model.Account;

public interface AccountService {
    boolean createAccount(Account account);
    boolean getAccountByUserNameAndPassword(Account account);
    Account getAccountByUserName(Account account);

    AccountResult deposit(Account account, double amount);
    AccountResult withdraw(Account account, double amount);
}
