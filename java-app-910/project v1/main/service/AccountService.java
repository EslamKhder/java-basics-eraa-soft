package main.service;

import main.model.Account;

public interface AccountService {

    boolean createAccount(Account account);

    boolean getAccountByUserNameAndPassword(Account account);
}
