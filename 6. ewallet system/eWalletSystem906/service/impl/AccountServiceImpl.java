package main.eWalletSystem906.service.impl;

import main.eWalletSystem906.model.Account;
import main.eWalletSystem906.model.EWallet;
import main.eWalletSystem906.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private EWallet eWallet = new EWallet();

    @Override
    public boolean createAccount(Account account) {
        // TODO CHECK PHONE NUMBER IS EXIST
        if (checkIfAccountExist(account) != -1) {
            return false;
        }
        eWallet.getAccounts().add(account);
        return true;
    }


    @Override
    public boolean login(Account account) {
        List<Account> accounts = eWallet.getAccounts();
        for (Account acc: accounts){
            if (acc.getUserName().equals(account.getUserName()) &&
                    acc.getPassword().equals(account.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deposit(Account account, double money) {
        int accountIndex = checkIfAccountExist(account);
        if (accountIndex == -1) {
            return false;
        }

        eWallet.getAccounts().get(accountIndex).setBalance(
                eWallet.getAccounts().get(accountIndex).getBalance() + money
        );

        return true;
    }

    @Override
    public int withDraw(Account account, double money) { // 3 result  true  false  false
        int accountIndex = checkIfAccountExist(account);
        if (accountIndex == -1) {
            return 1;
        }

        if (!(eWallet.getAccounts().get(accountIndex).getBalance() >= money)){
            return 2;
        }

        eWallet.getAccounts().get(accountIndex).setBalance(
                eWallet.getAccounts().get(accountIndex).getBalance() - money
        );

        return 3;
    }

    /**
     *
     * @param account
     * @param userNameAccountTransfer
     * @param money
     * @return
     */
    @Override
    public int transfer(Account account, String userNameAccountTransfer, double money) {
        // TODO if account not exist return 1
        // TODO if userNameAccountTransfer not exist return 2
        // TODO if money that will transfer is greater than account balance return 3
        // TODO If all above is true now ready to transfer
        // TODO transfer process cut money from account and add to userNameAccountTransfer then return 4
        return 0;
    }

    @Override
    public Account getAccount(Account account) {
        int accountIndex = checkIfAccountExist(account);
        if (accountIndex == -1) {
            return null;
        }
        return eWallet.getAccounts().get(accountIndex);
    }


    private int checkIfAccountExist(Account account) {
        List<Account> accounts = eWallet.getAccounts();
        for (int i=0;i<accounts.size();i++){
            if (accounts.get(i).getUserName().equals(account.getUserName())) {
                return i;
            }
        }
        return -1;
    }
}
