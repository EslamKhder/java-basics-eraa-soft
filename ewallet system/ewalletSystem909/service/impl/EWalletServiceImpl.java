package main.ewalletSystem.service.impl;

import main.ewalletSystem.helper.AccountResult;
import main.ewalletSystem.model.Account;
import main.ewalletSystem.service.AccountService;
import main.ewalletSystem.service.AccountValidationService;
import main.ewalletSystem.service.ApplicationService;

import java.util.Objects;
import java.util.Scanner;

public class EWalletServiceImpl implements ApplicationService {

    private AccountService accountService = new AccountServiceImpl();

    private AccountValidationService accountValidationService = new AccountValidationServiceImpl();
    @Override
    public void startApp() {
        System.out.println("welcome sir :)");
        boolean isExist = false;
        int counter = 0;
        while (true) {
            System.out.println("pls enter your service :)");
            System.out.println("1.login           2.signup             3.Exit");
            Scanner scanner = new Scanner(System.in);
            int service = scanner.nextInt();

            switch (service) {
                case 1:
                    login();
                    break;
                case 2:
                    signup();
                    break;
                case 3:
                    System.out.println("have a nice day :)");
                    isExist = true;
                    break;
                default:
                    System.out.println("invalid choose :(");
                    counter++;
            }

            if (isExist) {
                break;
            }

            if (counter == 3) {
                System.out.println("pls contact with admin :(");
                break;
            }
        }
    }

    private void login(){
        Account account = getAccount(true);

        if (Objects.isNull(account)) {
            return;
        }
        boolean loginSuccess = accountService.getAccountByUserNameAndPassword(account);
        if (loginSuccess) {
            System.out.println("success login :)");
            profile(account);
        } else {
            System.out.println("invalid username or password :(");
        }

    }

    private void signup(){
        Account account = getAccount(false);

        if (Objects.isNull(account)) {
            return;
        }
        // service to add account on EWallet system
        boolean isAccountCreated = accountService.createAccount(account);

        if (isAccountCreated) {
            System.out.println("account created success :)");
            profile(account);
        } else {
            System.out.println("account already exist with same username " + account.getPassword());
        }
    }

    private Account getAccount(boolean login){

        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter your username: ");
        String userName = sc.next();

        if (!accountValidationService.validateUserName(userName)) {
            System.out.println("invalid user name ..........");
            return null;
        }

        System.out.print("Please enter your password: ");
        String password = sc.next();

        if (!accountValidationService.validatePassword(password)) {
            System.out.println("invalid password ..........");
            return null;
        }

        if (login) {
            return new Account(userName, password);
        }

        System.out.print("Please enter your phone number: ");
        String phoneNumber = sc.next();

        System.out.print("Please enter your address: ");
        String address = sc.next();

        System.out.print("Please enter your age: ");
        float age = sc.nextFloat();

        return new Account(userName, password, phoneNumber, address, age);
    }


    private void profile(Account account){
        boolean logout = false;
        int counter = 0;
        while (true) {
            System.out.println("----------> services <------------");
            System.out.println("1.deposit     2.withdraw   3.show account details    4.logout");
            Scanner scanner = new Scanner(System.in);
            System.out.println("pls give me service you need to apply.");
            int result = scanner.nextInt();

            switch (result) {
                case 1:
                    deposit(account);
                    break;
                case 2:
                    withdraw(account);
                    break;
                case 3:
                    showAccountDetails(account);
                    break;
                case 4:
                    System.out.println("have a nice day :)");
                    logout = true;
                    break;
                default:
                    System.out.println("invalid service");
                    counter++;
            }
            if (logout){
                break;
            }

            if (counter == 3) {
                System.out.println("pls contact with admin :(");
                break;
            }
        }

    }

    private void showAccountDetails(Account account) {
        Account accountExist = accountService.getAccountByUserName(account);

        if (Objects.isNull(accountExist)) {
            System.out.println("account not exist :(");
            return;
        }

        System.out.println(account);
    }

    private void withdraw(Account account) {
        System.out.println("pls enter amount you need to deposit");
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();

        AccountResult withdrawSuccess = accountService.withdraw(account, amount);

        Integer error = withdrawSuccess.getError();
        if (error == 4) {
            System.out.println("withdraw Success your balance : " + withdrawSuccess.getAmount());
        } else if (error == 3){
            System.out.println("amount you need to withdraw greater than your Balance :(");
        } else if (error == 2) {
            System.out.println("amount must be greater than or equal 100 :(");
        } else if (error == 1) {
            System.out.println("Account not exist :(");
        }
    }

    private void deposit(Account account) {
        System.out.println("pls enter amount you need to deposit");
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();

        AccountResult depositSuccess = accountService.deposit(account, amount);

        Integer error = depositSuccess.getError();
        if (error == 3) {
            System.out.println("deposit Success your balance : " + depositSuccess.getAmount());
        } else if (error == 2){
            System.out.println("amount must be greater than or equal 100 :(");
        } else if (error == 1) {
            System.out.println("Account not exist :(");
        }
    }
}
