package main.project908.service.impl;

import main.project908.model.Account;
import main.project908.model.EWalletSystem;
import main.project908.service.AccountService;
import main.project908.service.ApplicationService;

import java.util.Objects;
import java.util.Scanner;

public class EWalletServiceImpl implements ApplicationService {

    private Scanner scanner = new Scanner(System.in);

    private AccountService accountService = new AccountServiceImpl();
    @Override
    public void startApp() {
        System.out.println("---------- hi sir welcome to " + EWalletSystem.getName() + " ----------");

        int counter = 0;
        while (true) {
            boolean isExit = false;
            System.out.println("pls choose.");
            System.out.println("a.login     b.signup     c.exit");

            char choose = scanner.next().charAt(0);

            switch (choose) {
                case 'a':
                    login();
                    break;
                case 'b':
                    signup();
                    break;
                case 'c':
                    System.out.println("have a nice day :)");
                    isExit = true;
                    break;
                default:
                    System.out.println("invalid choose :(");
                    counter++;
            }

            if (counter == 4) {
                System.out.println("pls try after 1 min :(");
                break;
            }

            if (isExit){
                break;
            }
        }
    }

    private void signup() {

        System.out.println("pls enter username.");
        String username = scanner.nextLine();
        System.out.println("pls enter password.");
        String password = scanner.nextLine();
        System.out.println("pls enter phone number.");
        String phoneNumber = scanner.nextLine();

        Account account = new Account(username, password, phoneNumber);

        if (accountService.createAccount(account)) {
            System.out.println("Account created success :)");
        } else {
            System.out.println("user name already exist on system :(");
        }

    }

    private void login() {
        // TODO get username and password from user
        // TODO validate if user exist
        // TODO if user exist got to main profile contain (1.deposit 2.withdraw 3.show_details 4.logout)

        System.out.println("pls enter username.");
        String username = scanner.nextLine();
        System.out.println("pls enter password.");
        String password = scanner.nextLine();

        Account account = new Account(username, password);
        account = accountService.getAccount(account);

        if (Objects.nonNull(account)){
            // TODO main profile
            mainProfile(account);
        } else {
            System.out.println("invalid username or password :(");
        }
    }

    private void mainProfile(Account account) {
        System.out.println("1.deposit  2.withdraw  3.show_details   4.logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt(); // assuming you have a Scanner named 'scanner'

            switch (choice) {
                case 1:
                    deposit(account);
                    break;

                case 2:
                    withDraw(account);
                    break;

                case 3:
                    showAccountDetails(account);
                    break;

                case 4:
                    System.out.println("Logging out...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

    void deposit(Account account){
        System.out.println("pls enter amount.");
        double amount = scanner.nextDouble();
        accountService.deposit(account, amount);
    }


    void withDraw(Account account){
        System.out.println("pls enter amount.");
        double amount = scanner.nextDouble();
        accountService.withdraw(account, amount);

    }

    void showAccountDetails(Account account){

    }






}
