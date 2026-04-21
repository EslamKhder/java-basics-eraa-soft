package main.g911.ewalletsystem.service.impl;

import main.g911.ewalletsystem.model.Account;
import main.g911.ewalletsystem.model.EWalletSystem;
import main.g911.ewalletsystem.service.AccountService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Implementation of AccountService.
 *
 * This class contains the actual business logic for handling accounts
 * inside the e-wallet system.
 */
public class AccountServiceImpl implements AccountService {

    /**
     * Represents the system storage (in-memory).
     *
     * NOTE:
     * - This is a simple approach (acts like a fake database).
     * - In real-world applications, this would be replaced with a repository (e.g., JPA Repository).
     */
    private EWalletSystem eWalletSystem = new EWalletSystem();

    /**
     * Creates a new account if the username does not already exist.
     *
     * Steps:
     * 1. Check if there is any account with the same username
     * 2. If exists → return false (prevent duplicates)
     * 3. Otherwise → add the account to the system
     *
     * @param account the account to be created
     * @return true if created successfully, false if username already exists
     */
    @Override
    public Account createAccount(Account account) {

        // Check if any account already has the same username
        Optional<Account> accountOptional = eWalletSystem.getAccounts()
                .stream()
                .filter(acc -> acc.getUserName().equals(account.getUserName())).findFirst();

        // If username already exists → do not create account
        if (accountOptional.isPresent()) {
            return null;
        }

        // Add the new account to the system
        eWalletSystem.getAccounts().add(account);

        return account;
    }

    /**
     * Validates whether an account exists using username and password.
     *
     * Steps:
     * 1. Search for an account matching both username and password
     * 2. If found → return true (valid credentials)
     * 3. Otherwise → return false
     *
     * @param account contains login credentials (username & password)
     * @return true if credentials are valid, false otherwise
     */
    @Override
    public Account isAccountExistByUserNameAndPassword(Account account) {
        // Check if any account matches both username AND password

        return eWalletSystem.getAccounts().stream()
                .filter(acc -> acc.getUserName().equals(account.getUserName()) &&
                               acc.getPassword().equals(account.getPassword())).findFirst().orElse(null);

//        Optional<Account> accountOptional = eWalletSystem.getAccounts().stream()
//                .filter(acc -> acc.getUserName().equals(account.getUserName()) &&
//                               acc.getPassword().equals(account.getPassword())).findFirst();
//
//        if (accountOptional.isPresent()) {
//            return accountOptional.get();
//        }
//
//        return null;
    }

//    @Override
//    public Boolean deposit(Account account, double amount) {
//
//        // TODO amount must be 100 200 300 400 ...... etc
//        if (amount < 100) {
//            return false;
//        }
//
//        // []
//        // [0,1,2,3,4]
//        int index = IntStream.range(0, eWalletSystem.getAccounts().size())
//                .filter(i -> {
//                    Account acc = eWalletSystem.getAccounts().get(i);
//                    return acc.getUserName().equals(account.getUserName()) &&
//                            acc.getPassword().equals(account.getPassword());
//                })
//                .findFirst()
//                .orElse(-1);
//
//        if (index == -1) {
//            return false;
//        }
//
//        double totalBalance = eWalletSystem.getAccounts().get(index).getBalance() + amount;
//        eWalletSystem.getAccounts().get(index).setBalance(totalBalance);
//
//        return true;
//    }

    @Override
    public void deposit(Account account, double amount) throws Exception {
        // TODO amount must be 100 200 300 400 ...... etc
        if (Objects.isNull(amount) || amount < 100) {
            throw new Exception("amount is null or amount must be greater than or equal 100");
        }

        if (Objects.isNull(account)) {
            throw new Exception("account is null");
        }

        Account accountExist = eWalletSystem.getAccounts().stream()
                .filter(acc -> acc.getUserName().equals(account.getUserName()) &&
                        acc.getPassword().equals(account.getPassword())).findFirst().orElse(null);

        if (Objects.isNull(accountExist)) {
            throw new Exception("account not exist");
        }

        double totalBalance = accountExist.getBalance() + amount;
        accountExist.setBalance(totalBalance);

    }
}
