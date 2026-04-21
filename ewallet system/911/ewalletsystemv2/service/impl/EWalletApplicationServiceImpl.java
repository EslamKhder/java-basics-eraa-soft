package main.g911.ewalletsystem.service.impl;

import main.g911.ewalletsystem.model.Account;
import main.g911.ewalletsystem.service.AccountService;
import main.g911.ewalletsystem.service.ApplicationService;
import main.g911.ewalletsystem.service.ValidationService;

import java.util.Objects;
import java.util.Scanner;

/**
 * Main application service responsible for handling user interaction (CLI).
 *
 * This class simulates a simple console-based e-wallet system where users can:
 * - Sign up
 * - Log in
 * - Navigate basic options
 */
public class EWalletApplicationServiceImpl implements ApplicationService {

    // Service layer dependency
    private AccountService accountService = new AccountServiceImpl();
    private ValidationService validationService = new ValidationServiceImpl();

    // Reuse one Scanner instead of creating multiple instances
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Entry point of the application.
     * Displays menu and handles user choices.
     */
    @Override
    public void start() {

        System.out.println("=================================");
        System.out.println("     Welcome to E-Wallet App     ");
        System.out.println("=================================\n");

        int invalidCounter = 0;
        boolean exit = false;

        while (true) {

            System.out.println("\nChoose an option:");
            System.out.println("[1] Login");
            System.out.println("[2] Sign Up");
            System.out.println("[3] Exit");
            System.out.print("Your choice: ");

            int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    login();
                    break;

                case 2:
                    signup();
                    break;

                case 3:
                    System.out.println("\nThank you for using E-Wallet. Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
                    invalidCounter++;
            }

            // Exit condition
            if (exit) {
                break;
            }

            // Too many invalid attempts
            if (invalidCounter == 4) {
                System.out.println("\nToo many invalid attempts.");
                System.out.println("Please contact support.");
                break;
            }
        }
    }

    /**
     * Handles user registration (sign up).
     */
    private void signup() {

        System.out.println("\n========== Sign Up ==========");

        System.out.print("Enter username: ");
        String userName = scanner.next();

        // TODO if input invalid pls make to enter ag
        boolean isUserNameValid = validationService.isUserNameValid(userName);
        if (!isUserNameValid) {
            System.out.println("invalid username [.....]");
            return;
        }

        // TODO apply for all inputs like UserName
        System.out.print("Enter password: ");
        String password = scanner.next();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.next();

        System.out.print("Enter age: ");
        float age = scanner.nextFloat();

        // Create account object
        Account account = new Account(userName, password, phoneNumber, age);

        // Call service layer
        account = accountService.createAccount(account);

        if (Objects.nonNull(account)) {
            System.out.println("\nAccount created successfully!");
            mainProfile(account);
        } else {
            System.out.println("\nSignup failed: Username already exists.");
        }
    }

    /**
     * Handles user login.
     */
    private void login() {

        System.out.println("\n========== Login ==========");

        // TODO apply validation if input invalid pls make to enter ag
        System.out.print("Enter username: ");
        String userName = scanner.next();

        // TODO apply validation for all inputs like UserName
        System.out.print("Enter password: ");
        String password = scanner.next();

        // Create account object with login credentials
        Account account = new Account(userName, password);

        // Validate credentials
        account = accountService.isAccountExistByUserNameAndPassword(account);

        if (Objects.nonNull(account)) {
            System.out.println("\nLogin successful!");
            mainProfile(account);
        } else {
            System.out.println("\nInvalid username or password.");
        }
    }

    /**
     * Displays main profile options after login/signup.
     *
     * NOTE:
     * Currently only displays options (no logic implemented yet).
     */
    private void mainProfile(Account account) { //

        // TODO Apply when feature end pls go to Main Menu until choose Logout
        // TODO Apply if enter mulite invalid choose
        // TODO if logout pls go to login main
        System.out.println("\n========== Main Menu ==========");
        System.out.println("[1] Deposit");
        System.out.println("[2] Withdraw");
        System.out.println("[3] Transfer");
        System.out.println("[4] Show Profile Details");
        System.out.println("[5] Change Password");
        System.out.println("[6] Remove Account");
        System.out.println("[7] Logout");

        System.out.println("pls Enter your feature: ");
        int feature = scanner.nextInt();

        switch (feature) {
            case 1:
                deposit(account);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                showProfileDetails(account);
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            default:
        }
    }

    /**
     * deposit
     * @param account
     */
    private void deposit(Account account) {
        System.out.println("pls enter amount you need to deposit.");
        double amount = scanner.nextDouble();
        try {
            accountService.deposit(account, amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * show Profile Details
     * @param account
     */
    private void showProfileDetails(Account account) {
        System.out.println("=================================");
        System.out.println("           Account Data          ");
        System.out.println("=================================\n");

        System.out.println("Username: " + account.getUserName());
        System.out.println("Password: " + account.getPassword());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Phone Number: " + account.getPhoneNumber());
        System.out.println("Age: " + account.getAge());
    }
}