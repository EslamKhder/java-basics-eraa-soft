package main.project908.service.impl;

import main.project908.model.Account;
import main.project908.model.EWalletSystem;
import main.project908.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private EWalletSystem eWalletSystem = new EWalletSystem();

    @Override
    public boolean createAccount(Account account) {
        // TODO PLS validate if user exist on E-Wallet or not
        List<Account> accounts = eWalletSystem.getAccounts();
        for(Account acc : accounts){
            if (acc.getUserName().equals(account.getUserName())) {
              return false;
            }
        }
        // TODO if exist return false
        // TODO if not exist return true
        eWalletSystem.getAccounts().add(account);
        return true;
    }

    @Override
    public Account getAccount(Account account) {
        // TODO pls Impl
        return null;
    }

    @Override
    public boolean deposit(Account account, double amount) {
        // TODO validate account exist or not
        // TODO if not exist pls rejected
        // TODO if exist pls add amount to balance
        return false;
    }

    @Override
    public boolean withdraw(Account account, double amount) {
        // TODO validate account exist or not
        // TODO amount >= balance
        // TODO pls cut amount and return true else return false
        return false;
    }

}
