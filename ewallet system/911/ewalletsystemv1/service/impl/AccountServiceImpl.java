package main.g911.ewalletsystem.service.impl;

import main.g911.ewalletsystem.model.Account;
import main.g911.ewalletsystem.model.EWalletSystem;
import main.g911.ewalletsystem.service.AccountService;

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
    public Boolean createAccount(Account account) {

        // Check if any account already has the same username
        boolean isAccountExist = eWalletSystem.getAccounts()
                .stream()
                .anyMatch(acc -> acc.getUserName().equals(account.getUserName()));

        // If username already exists → do not create account
        if (isAccountExist) {
            return false;
        }

        // Add the new account to the system
        eWalletSystem.getAccounts().add(account);

        return true;
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
    public Boolean isAccountExistByUserNameAndPassword(Account account) {

        // Check if any account matches both username AND password
        boolean isAccountExist = eWalletSystem.getAccounts()
                .stream()
                .anyMatch(acc ->
                        acc.getUserName().equals(account.getUserName()) &&
                                acc.getPassword().equals(account.getPassword())
                );

        // Return result directly (true if found, false otherwise)
        return isAccountExist;
    }
}