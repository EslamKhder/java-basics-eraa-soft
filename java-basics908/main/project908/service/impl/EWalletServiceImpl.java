package main.project908.service.impl;

import main.project908.model.Account;
import main.project908.model.EWalletSystem;
import main.project908.service.AccountService;
import main.project908.service.AccountValidationService;
import main.project908.service.ApplicationService;

import java.util.Objects;
import java.util.Scanner;

// TODO remove any duplicated code
// TODO  fix any runtime exception try catch
public class EWalletServiceImpl implements ApplicationService {

    private Scanner scanner = new Scanner(System.in);

    private AccountService accountService = new AccountServiceImpl();
    private AccountValidationService accountValidationService = new AccountValidationServiceImpl();
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
                    login(); // *******************
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
        scanner = new Scanner(System.in);
        System.out.println("pls enter username.");
        String username = scanner.nextLine();
        if (!accountValidationService.isUserNameValid(username)) {
            System.out.println("invalid user name :(");
            return;
        }
        // TODO APPLY Validation for password and phone number
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
        scanner = new Scanner(System.in);
        System.out.println("pls enter username.");
        String username = scanner.nextLine();
        System.out.println("pls enter password.");
        String password = scanner.nextLine();

        Account account = new Account(username, password);
        account = accountService.getAccount(account);

        if (Objects.nonNull(account)){
            System.out.println("success login :)");
            mainProfile(account);
        } else {
            System.out.println("invalid username or password :(");
        }
    }

    private void mainProfile(Account account) {
        while (true) {
            boolean isExit = false;
            System.out.println("1.deposit  2.withdraw  3.Transfer  4.show_details  6.change password  7.remove account   5.logout");
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
                    transfer(account);
                    break;

                case 4:
                    showAccountDetails(account);
                    break;

                case 5:
                    System.out.println("Logging out...");
                    isExit = true;
                    break;
                case 6:
                    changePassword(account);
                    break;
                case 7:
                    removeAccount(account);
                    break;


                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            if (isExit) {
                break;
            }
        }
    }

    private void removeAccount(Account account) {

    }

    private void changePassword(Account account) {

    }

    private void transfer(Account account) {
        scanner = new Scanner(System.in);
        System.out.println("pls enter user name of account you need to transfer.");
        String userName = scanner.nextLine();
        System.out.println("pls enter amount.");
        double amount = scanner.nextDouble();

        if (accountService.transfer(account, userName, amount)) {
            System.out.println("success transfer :)");
        } else {
            System.out.println("transfer failed :(");
        }
    }

    private void deposit(Account account){
        System.out.println("pls enter amount.");
        double amount = scanner.nextDouble();
        if (accountService.deposit(account, amount)) {
            System.out.println("success deposit :)");
        } else {
            System.out.println("deposit failed :(");
        }
    }


    void withDraw(Account account){
        System.out.println("pls enter amount.");
        double amount = scanner.nextDouble();

        if (accountService.withdraw(account, amount)) {
            System.out.println("success withDraw :)");
        } else {
            System.out.println("withDraw failed :(");
        }
    }

    void showAccountDetails(Account account){
        account = accountService.getAccount(account);
        System.out.println("1.username: " + account.getUserName());
        System.out.println("2.Password: " + account.getPassword());
        System.out.println("3.Balance: " + account.getBalance());
        System.out.println("4.PhoneNumber: " + account.getPhoneNumber());
    }

}
