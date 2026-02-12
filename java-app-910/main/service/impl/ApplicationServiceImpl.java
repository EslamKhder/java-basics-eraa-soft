package main.service.impl;

import main.model.Account;
import main.service.AccountService;
import main.service.ApplicationService;

import java.util.Scanner;

/**
 * Implementation of the ApplicationService interface.
 * Provides the main application flow and user interface for the e-wallet system.
 * Handles user interaction through console-based menus for login, signup, and profile management.
 *
 * @see ApplicationService
 * @see AccountService
 */
public class ApplicationServiceImpl implements ApplicationService {

    /**
     * Service dependency for handling account-related operations.
     * Used for user authentication and account creation.
     */
    private AccountService accountService = new AccountServiceImpl();

    /**
     * Starts the main application loop.
     * Displays the welcome message and presents the main menu with options for:
     * - Login (existing users)
     * - Signup (new users)
     * - Exit (terminate application)
     *
     * Includes a counter to limit invalid menu choices to 4 attempts.
     * After 4 invalid attempts, the application terminates with a message.
     */
    @Override
    public void startApplication() {
        System.out.println("---------> hello sir :) <------- ");

        int invalidAttemptsCounter = 0;

        while (true) {
            System.out.println("1.login     2.signup     3.Exit");
            System.out.println("pls enter your choose.....");

            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();

            boolean isExit = false;

            switch (choose) {
                case 1:
                    login();
                    break;
                case 2:
                    signup();
                    break;
                case 3:
                    System.out.println("have a nice day :)...");
                    isExit = true;
                    break;
                default:
                    System.out.println("invalid choose");
                    invalidAttemptsCounter++;
            }

            if (isExit) break;

            if (invalidAttemptsCounter == 4) {
                System.out.println("many times invalid choose pls contact with admin :(.....");
                break;
            }
        }
    }

    /**
     * Handles the user login process.
     * Prompts the user for username and password, then authenticates the credentials
     * using the AccountService.
     *
     * Process flow:
     * 1. Collect username and password from user input
     * 2. Create an Account object with the provided credentials
     * 3. Verify credentials through AccountService
     * 4. Display success message and navigate to profile on successful login
     * 5. Display error message on failed authentication
     *
     * @implNote Currently relies on AccountService implementation that only checks
     *           username existence, not password verification. This is a security limitation.
     */
    private void login(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("pls enter username: ");
        String userName = scanner.next();

        System.out.println("pls enter password: ");
        String password = scanner.next();

        Account account = new Account(userName, password);

        boolean isAccountExist = accountService.getAccountByUserNameAndPassword(account);

        if (isAccountExist) {
            System.out.println("login success :) ...");
            showProfile();
        } else {
            System.out.println("invalid user name or password :( ...");
        }
    }

    /**
     * Handles the new user registration process.
     * Collects all required user information and creates a new account.
     *
     * Process flow:
     * 1. Prompt user for all required registration details:
     *    - Username (must be unique)
     *    - Password
     *    - Age
     *    - Phone Number
     * 2. Create an Account object with all provided information
     * 3. Attempt to create the account through AccountService
     * 4. Display success message and navigate to profile on successful creation
     * 5. Display error message if username already exists
     */
    private void signup(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("pls enter username: ");
        String userName = scanner.next();

        System.out.println("pls enter password: ");
        String password = scanner.next();

        System.out.println("pls enter age: ");
        float age = scanner.nextFloat();

        System.out.println("pls enter Phone Number: ");
        String phoneNumber = scanner.next();

        Account account = new Account(userName, password, age, phoneNumber);

        boolean isAccountCreated = accountService.createAccount(account);

        if (isAccountCreated) {
            System.out.println("account created success :) ...");
            showProfile();
        } else {
            System.out.println("user name already exist on system :( ...");
        }
    }

    /**
     * Displays the user profile menu after successful login or registration.
     * Provides access to core e-wallet functionalities.
     *
     * Available options:
     * 1. deposit - Add funds to the account
     * 2. withdraw - Remove funds from the account
     * 3. show balance - Display current account balance
     * 4. logout - Return to main menu
     *
     * @implNote This is a placeholder implementation. The actual functionality
     *           for deposit, withdraw, and balance operations is not yet implemented.
     *           Currently only reads user input without processing the selected option.
     */
    private void showProfile(){
        System.out.println("1.deposit   2.withdraw   3.show balance   4.logout");

        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        // TODO: Implement deposit, withdraw, balance check, and logout functionality
    }
}