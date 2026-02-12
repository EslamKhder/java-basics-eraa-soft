package main.service.impl;

import main.model.Account;
import main.model.EWalletSystem;
import main.service.AccountService;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the AccountService interface.
 * Provides concrete functionality for managing user accounts in the e-wallet system.
 * Handles account creation and authentication operations.
 *
 * @see AccountService
 * @see EWalletSystem
 */
public class AccountServiceImpl implements AccountService {

    /**
     * The e-wallet system instance that holds all application data.
     * This includes the collection of all registered user accounts.
     */
    private EWalletSystem eWalletSystem = new EWalletSystem();

    /**
     * Creates a new user account in the e-wallet system.
     *
     * Account creation process:
     * 1. Checks if a user with the same username already exists
     * 2. If username is unique, adds the account to the system
     * 3. If username already exists, rejects the creation request
     *
     * @param account The account object containing user details (username, password, etc.)
     * @return boolean
     *         - {@code true} if account is successfully created (username doesn't exist)
     *         - {@code false} if account creation fails (username already exists)
     */
    @Override
    public boolean createAccount(Account account) {
        // Retrieve all existing accounts from the system
        List<Account> accounts = eWalletSystem.getAccounts();

        // Check if an account with the same username already exists
        Optional<Account> optionalAccount = accounts.stream()
                .filter(acc -> acc.getUserName().equals(account.getUserName()))
                .findAny();

        // If username is already taken, reject account creation
        if (optionalAccount.isPresent()) {
            return false;
        }

        // Add the new account to the system
        eWalletSystem.getAccounts().add(account);
        return true;
    }


    /**
     * Authenticates a user by verifying their username and password.
     *
     * Note: This method currently only checks for username existence,
     * not password verification. This is a security limitation that
     * should be addressed in future implementations.
     *
     * @param account The account object containing the credentials to verify
     * @return boolean
     *         - {@code true} if an account with the given username exists
     *         - {@code false} if no account with the given username is found
     * @implNote Currently only validates username, not password.
     *           Should be enhanced to include password verification for proper authentication.
     */
    @Override
    public boolean getAccountByUserNameAndPassword(Account account) {
        // Retrieve all existing accounts from the system
        List<Account> accounts = eWalletSystem.getAccounts();

        // Search for an account with the matching username
        Optional<Account> optionalAccount = accounts.stream()
                .filter(acc -> acc.getUserName().equals(account.getUserName()))
                .findAny();

        // Return true if username exists, false otherwise
        return optionalAccount.isPresent();
    }
}