package main.ewallet907.service.impl;

import main.ewallet907.model.Account;
import main.ewallet907.model.EWallet;
import main.ewallet907.service.AccountService;

// TODO pls remove duplicated code
// TODO use streaming API
public class AccountServiceImpl implements AccountService {

    private EWallet eWallet = new EWallet();


    @Override
    public boolean createAccount(Account account) {

        for (Account acc: eWallet.getAccounts()) {
            if (acc.getUserName().equals(account.getUserName())) {
                return false;
            }
        }

        eWallet.getAccounts().add(account);
        return true;
    }

    @Override
    public Account getAccount(Account account) {
        for (Account acc: eWallet.getAccounts()) {
            if (acc.getUserName().equals(account.getUserName()) &&
                acc.getPassword().equals(account.getPassword())) {
                return acc;
            }
        }

        return null;
    }

    @Override
    public boolean deposit(Account account, double mount) { // 50        30
        for (Account acc: eWallet.getAccounts()) {
            if (acc.getUserName().equals(account.getUserName())) {
                double oldBalance = acc.getBalance();
                acc.setBalance(oldBalance + mount);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean withdraw(Account account, double mount) {
        /**
         * TODO check account exist
         * TODO check balance on account is greater than or equal mount
         * if account exist and balance on account is greater than or equal mount  *cut mount from account  *return true
         * else return false
         */
        return false;
    }

    @Override
    public boolean transfer(Account account, String userName, double amount) {
        /**
         * TODO check account exist
         * TODO check userName exist
         * TODO check balance on account is greater than or equal mount
         * if All condition true cut amount from account and add to this account userName amount return true
         * else return false
         */
        return false;
    }
}
