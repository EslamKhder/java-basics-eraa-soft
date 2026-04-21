package main.g911.ewalletsystem.service;

import main.g911.ewalletsystem.model.Account;

/**
 * Service interface responsible for handling business logic
 * related to Account operations in the e-wallet system.
 *
 * This layer typically sits between the Controller and Repository,
 * and contains business rules rather than just basic CRUD operations.
 */
public interface AccountService {

    /**
     * Creates a new account in the system.
     *
     * Expected behavior:
     * - Validate account data (e.g., username not null, password strength, etc.)
     * - Optionally check if the account already exists (e.g., duplicate username)
     * - Persist the account into the database
     *
     * @param account the Account object containing user details
     * @return Boolean
     *         - true  → if the account is created successfully
     *         - false → if creation fails (e.g., validation error or duplicate account)
     */
    Boolean createAccount(Account account);

    /**
     * Checks whether an account exists using username and password.
     *
     * Commonly used in authentication (login process).
     *
     * Expected behavior:
     * - Retrieve account by username
     * - Compare stored password with the provided password
     *   (NOTE: In real applications, passwords should be hashed and never stored in plain text)
     *
     * @param account the Account object containing login credentials
     * @return Boolean
     *         - true  → if account exists and credentials are valid
     *         - false → if account does not exist or credentials are invalid
     */
    Boolean isAccountExistByUserNameAndPassword(Account account);
}