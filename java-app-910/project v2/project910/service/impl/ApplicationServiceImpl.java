package main.project910.service.impl;

import main.project910.model.Account;
import main.project910.service.AccountService;
import main.project910.service.ApplicationService;

import java.util.Objects;
import java.util.Scanner;

/**
 * TODO pls remove duplication on code
 * TODO pls use try catch
 * TODO pls clean code
 * TODO pls use stream api
 * TODO show clear message for (withdraw failed, Deposit failed )
 *
 * TODO Pls USE AI to format coding
 */

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

    private ValidationServiceImpl validationService = new ValidationServiceImpl();
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
                    signup(); // *
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

        Account account = new Account(userName, password); // eslam  123

        Account accountLogin = accountService.getAccountByUserNameAndPassword(account);

        if (Objects.nonNull(accountLogin)) {
            System.out.println("login success :) ...");
            showProfile(accountLogin);
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
        String userName = null;
        boolean validUserName = false;
        do {
            System.out.println("pls enter username: ");
            userName = scanner.next();
            validUserName = validationService.validateUSerName(userName);
            if (!validUserName) {
                System.out.println("invalid userName");
            }
        } while (!validUserName);


        System.out.println("pls enter password: ");
        String password = scanner.next();

        System.out.println("pls enter age: ");
        float age = scanner.nextFloat();

        System.out.println("pls enter Phone Number: ");
        String phoneNumber = scanner.next();

        Account account = new Account(userName, password, age, phoneNumber);

        Account accountCreated = accountService.createAccount(account);

        if (Objects.nonNull(accountCreated)) {
            System.out.println("account created success :) ...");
            showProfile(accountCreated); // *
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
    private void showProfile(Account account){

        while (true) {
            System.out.println("1.deposit   2.withdraw  3.Transfer   4.show balance    5.show details   6.Change Password   7.logout");
            boolean isExit = false;
            boolean invalidChoose = false;
            Scanner scanner = new Scanner(System.in);
            System.out.println("pls choose....");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    deposit(account);
                    break;
                case 2:
                    withdraw(account);
                    break;
                case 7:
                    System.out.println("logout success have a nice day .......");
                    isExit = true;
                    break;
                default:
                    System.out.println("invalid choose...");
                    invalidChoose = true;
            }
            if (isExit) {
                break;
            }

            if (invalidChoose) {
                continue;
            }

            System.out.println("are you need to do new feature ...... :)");
            System.out.println("1.yes        2.no");
            int feature = scanner.nextInt();
            if (feature == 2) {
                break;
            }
        }
    }

    private void withdraw(Account account) {
        System.out.println("----> your details is <-------");
        System.out.println("username: " + account.getUserName());
        System.out.println("Password: " + account.getPassword());
        System.out.println("PhoneNumber: " + account.getPhoneNumber());
        System.out.println("Age: " + account.getAge());
        System.out.println("Balance: " + account.getBalance());

        System.out.println("-------> pls enter amount to withdraw..");
        Scanner scanner = new Scanner(System.in);

        double amount = scanner.nextDouble();
        Account accountWithdrawSuccess = accountService.withdraw(account, amount);

        // account  amount
        if (Objects.nonNull(accountWithdrawSuccess)){
            System.out.println("withdraw Success and current balance is : " + accountWithdrawSuccess.getBalance());
        } else {
            System.out.println("withdraw failed ");
        }
    }

    private void deposit(Account account){
        System.out.println("----> your details is <-------");
        System.out.println("username: " + account.getUserName());
        System.out.println("Password: " + account.getPassword());
        System.out.println("PhoneNumber: " + account.getPhoneNumber());
        System.out.println("Age: " + account.getAge());
        System.out.println("Balance: " + account.getBalance());

        System.out.println("-------> pls enter amount to deposit..");
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();

        Account accountDepositSuccess = accountService.deposit(account, amount);

        // account  amount
        if (Objects.nonNull(accountDepositSuccess)){
            System.out.println("Deposit Success and current balance is : " + accountDepositSuccess.getBalance());
        } else {
            System.out.println("Deposit failed ");
        }

    }
}