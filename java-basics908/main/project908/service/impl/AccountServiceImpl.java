package main.project908.service.impl;

import main.project908.model.Account;
import main.project908.model.EWalletSystem;
import main.project908.service.AccountService;

import java.util.List;

// TODO remove any duplicated code
public class AccountServiceImpl implements AccountService {

    private EWalletSystem eWalletSystem = new EWalletSystem();

    @Override
    public boolean createAccount(Account account) {
        List<Account> accounts = eWalletSystem.getAccounts();
        for(Account acc : accounts){
            if (acc.getUserName().equals(account.getUserName())) {
              return false;
            }
        }
        eWalletSystem.getAccounts().add(account);
        return true;
    }

    @Override
    public Account getAccount(Account account) {

        List<Account> accounts = eWalletSystem.getAccounts();
        for(Account acc : accounts){
            if (acc.getUserName().equals(account.getUserName()) &&
                    acc.getPassword().equals(account.getPassword())) {
                return acc;
            }
        }

        return null;
    }


    @Override
    public boolean withdraw(Account account, double amount) {
        List<Account> accounts = eWalletSystem.getAccounts();

        int accountIndex = -1;
        for(int i = 0;i<accounts.size();i++){
            if (accounts.get(i).getUserName().equals(account.getUserName())) {
                accountIndex = i;
                break;
            }
        }

        if(accountIndex == -1){
            return false;
        }

        Account existedAccount = eWalletSystem.getAccounts().get(accountIndex);

        if (existedAccount.getBalance() < amount) {
            return false;
        }

        existedAccount.setBalance(existedAccount.getBalance() - amount);

        return true;
    }

    @Override
    public boolean transfer(Account account, String userNameTransfer, double amount) {
        List<Account> accounts = eWalletSystem.getAccounts();

        int accountExistIndex = -1;
        int accountTransferIndex = -1;
        for(int i = 0;i<accounts.size();i++){
            if (accounts.get(i).getUserName().equals(account.getUserName())) {
                accountExistIndex = i;
            }

            if (accounts.get(i).getUserName().equals(userNameTransfer)) {
                accountTransferIndex = i;
            }
        }

        if(accountExistIndex == -1 || accountTransferIndex == -1 || accountExistIndex == accountTransferIndex){
            return false;
        }

        boolean isValidBalance = accounts.get(accountExistIndex).getBalance() < amount;

        if(isValidBalance){
            return false;
        }

        accounts.get(accountExistIndex).setBalance(
                accounts.get(accountExistIndex).getBalance() - amount
        );

        accounts.get(accountTransferIndex).setBalance(
                accounts.get(accountTransferIndex).getBalance() + amount
        );

        return true;
    }


    @Override
    public boolean deposit(Account account, double amount) { // Balance = 100
        List<Account> accounts = eWalletSystem.getAccounts();

        int accountIndex = -1;
        for(int i = 0;i<accounts.size();i++){
            if (accounts.get(i).getUserName().equals(account.getUserName())) {
                accountIndex = i;
                break;
            }
        }

        if(accountIndex == -1){
            return false;
        }

        double newBalance = eWalletSystem.getAccounts().get(accountIndex).getBalance() + amount;
        eWalletSystem.getAccounts().get(accountIndex).setBalance(newBalance);

        return true;
    }

}
