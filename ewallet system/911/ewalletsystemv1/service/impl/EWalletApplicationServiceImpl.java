package main.g911.ewalletsystem.service.impl;

import main.g911.ewalletsystem.model.Account;
import main.g911.ewalletsystem.service.AccountService;
import main.g911.ewalletsystem.service.ApplicationService;

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

        System.out.print("Enter password: ");
        String password = scanner.next();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.next();

        System.out.print("Enter age: ");
        float age = scanner.nextFloat();

        // Create account object
        Account account = new Account(userName, password, phoneNumber, age);

        // Call service layer
        boolean isAccountCreated = accountService.createAccount(account);

        if (isAccountCreated) {
            System.out.println("\nAccount created successfully!");
            mainProfile();
        } else {
            System.out.println("\nSignup failed: Username already exists.");
        }
    }

    /**
     * Handles user login.
     */
    private void login() {

        System.out.println("\n========== Login ==========");

        System.out.print("Enter username: ");
        String userName = scanner.next();

        System.out.print("Enter password: ");
        String password = scanner.next();

        // Create account object with login credentials
        Account account = new Account(userName, password);

        // Validate credentials
        boolean isAccountExist =
                accountService.isAccountExistByUserNameAndPassword(account);

        if (isAccountExist) {
            System.out.println("\nLogin successful!");
            mainProfile();
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
    private void mainProfile() {

        System.out.println("\n========== Main Menu ==========");
        System.out.println("[1] Deposit");
        System.out.println("[2] Withdraw");
        System.out.println("[3] Logout");
        System.out.println("================================");

        // Future: implement actual logic here
    }
}