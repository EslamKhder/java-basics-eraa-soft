package main.ewalletSystem.service.impl;

import main.ewalletSystem.helper.AccountResult;
import main.ewalletSystem.model.Account;
import main.ewalletSystem.model.EWalletSystem;
import main.ewalletSystem.service.AccountService;

import java.util.Optional;
public class AccountServiceImpl implements AccountService {

    private EWalletSystem eWalletSystem = new EWalletSystem();


    /**
     * create new account
     * @param account
     * @return ture if account success - false if account already exist
     */
    @Override
    public boolean createAccount(Account account) {
        Optional<Account> optionalAccount = getOptionalAccountByUserName(account);
        if (optionalAccount.isPresent()) {
            return false;
        }
        eWalletSystem.getAccounts().add(account);
        return true;
    }

    /**
     * get Account
     * @param account
     * @return
     */
    @Override
    public boolean getAccountByUserNameAndPassword(Account account) {
        return eWalletSystem.getAccounts().stream()
                .anyMatch(acc -> acc.getUserName().equals(account.getUserName()) &&
                                 acc.getPassword().equals(account.getPassword()));

    }

    @Override
    public Account getAccountByUserName(Account account) {
        Optional<Account> optionalAccount = getOptionalAccountByUserName(account);

        if (optionalAccount.isEmpty()) {
            return null;
        }

        return optionalAccount.get();
    }

    /**
     * deposit
     * @param account
     * @param amount
     * @return
     */
    @Override
    public AccountResult deposit(Account account, double amount) {

        Optional<Account> optionalAccount = getOptionalAccountByUserName(account);
        if (optionalAccount.isEmpty()) {
            return new AccountResult(1);
        }

        // validate amount >= 100
        if (amount < 100) {
            return new AccountResult(2);
        }

        Account accountToDeposit = optionalAccount.get();
        accountToDeposit.setBalance(accountToDeposit.getBalance() + amount);

        return new AccountResult(3, accountToDeposit.getBalance());
    }

    @Override
    public AccountResult withdraw(Account account, double amount) {
        Optional<Account> optionalAccount = getOptionalAccountByUserName(account);
        if (optionalAccount.isEmpty()) {
            return new AccountResult(1);
        }

        // validate amount >= 100
        if (amount < 100) {
            return new AccountResult(2);
        }

        Account accountWithDraw = optionalAccount.get();

        if (accountWithDraw.getBalance() < amount) {
            return new AccountResult(3);
        }

        accountWithDraw.setBalance(accountWithDraw.getBalance() - amount);
        return new AccountResult(4, accountWithDraw.getBalance());
    }

    /**
     * get Optional Account By UserName
     * @param account
     * @return
     */
    private Optional<Account> getOptionalAccountByUserName(Account account) {
        Optional<Account> optionalAccount = eWalletSystem.getAccounts().stream()
                .filter(acc -> acc.getUserName().equals(account.getUserName())).findFirst();

        return optionalAccount;
    }


    // tra   accountFrom    accountTo  amount
    // validate accountFrom exist
    // validate accountTo   exist
    // validate amount   >= 100
    // validate accountFrom Balance   >= amount
    // validate accountFrom not  accountTo
    // cut amount form accountFrom and add to accountTo
}
