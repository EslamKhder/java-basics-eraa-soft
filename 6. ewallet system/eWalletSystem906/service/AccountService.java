package main.eWalletSystem906.service;

import main.eWalletSystem906.model.Account;

public interface AccountService {

    boolean createAccount(Account account);
    boolean login(Account account);

    boolean deposit(Account account, double money);
    int withDraw(Account account, double money);
    int transfer(Account account, String userNameAccountTransfer, double money);
    Account getAccount(Account account);
}
