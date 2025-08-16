package main.ewallet907.service.impl;

import main.ewallet907.model.Account;
import main.ewallet907.service.AccountService;
import main.ewallet907.service.ApplicationService;
import main.ewallet907.service.ValidationService;

import java.util.Objects;
import java.util.Scanner;

// TODO pls remove duplicated code
public class ApplicationServiceImpl implements ApplicationService {

    private AccountService accountService = new AccountServiceImpl();
    private ValidationService validationService = new ValidationServiceImpl();

    @Override
    public void startApp() {
        System.out.println("---------- hello sir -------------");

        int counter = 0;
        while (true) {
            boolean isExit = false;

            System.out.println("pls enter what you need to do?!");
            System.out.println("1.login              2.signup            3.Exit");
            Scanner scanner = new Scanner(System.in);
            int res = scanner.nextInt();

            switch (res) {
                case 1:
                    login();
                    break;
                case 2:
                    signup();
                    break;
                case 3:
                    System.out.println("have a nice day :)");
                    isExit = true;
                    break;
                default:
                    System.out.println("Invalid input :(");
                    counter++;
            }

            if(isExit){
                break;
            }

            if(counter == 4){
                System.out.println("pls try on last time :(");
                break;
            }
        }
    }

    private void signup() {
        Scanner scanner = new Scanner(System.in);

        // TODO apply do while on all attr
        boolean res = false;
        String userName = null;
        do {
            System.out.println("pls enter userName");
            userName = scanner.nextLine();
            res = !validationService.isUserNameValid(userName);
            if(res){
                System.out.println("invalid user name");
            }
        } while (res);

        System.out.println("pls enter password");
        String password = scanner.nextLine();
        if(!validationService.isPasswordValid(password)){
            System.out.println("invalid user name");
            return;
        }
        System.out.println("pls enter phoneNumber");
        String phoneNumber = scanner.nextLine();
        if(!validationService.isPhoneNumberValid(phoneNumber)){
            System.out.println("invalid user name");
            return;
        }
        System.out.println("pls enter age");
        Integer age = scanner.nextInt();
        if(!validationService.isAgeValid(age)){
            System.out.println("invalid user name");
            return;
        }

        Account account = new Account(userName, password, phoneNumber, age);

        boolean isAccountCreated = accountService.createAccount(account);
        if(isAccountCreated){
            System.out.println("account created success :)");
        } else {
            System.out.println("there exist account with same user name :(");
        }
    }

    private void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("pls enter userName");
        String userName = scanner.nextLine();
        System.out.println("pls enter password");
        String password = scanner.nextLine();

        Account account = new Account(userName, password);

        account = accountService.getAccount(account);

        if (Objects.nonNull(account)){
            System.out.println("Login success :)");
            mainPage(account);
        } else {
            System.out.println("invalid username or password :)");
        }
    }

    private void mainPage(Account account){
        while (true) {
            boolean isExit = false;
            Scanner scanner = new Scanner(System.in);
            // TODO pls apply withdraw, transfer, change password and remove account features
            System.out.println("1.deposit  2.withdraw  3.transfer  4.show account details  5.change password  6.remove account  7.logout");
            int res = scanner.nextInt();
            switch (res) {
                case 1:
                    deposit(account);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    showAccountDetails(account);
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:
                    isExit = true;
                    System.out.println("have a nice day :)");
                    break;
                default:

            }

            if (isExit) {
                break;
            }
        }
    }

    private void showAccountDetails(Account account) {
        account = accountService.getAccount(account);

        if (Objects.nonNull(account)){
            System.out.println("1.username: " + account.getUserName());
            System.out.println("2.Password: " + account.getPassword());
            System.out.println("3.Balance: " + account.getBalance());
            System.out.println("4.PhoneNumber: " + account.getPhoneNumber());
            System.out.println("5.Age: " + account.getAge());
        } else {
            System.out.println("invalid username or password :)");
        }
    }

    private void deposit(Account account) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("pls enter amount");
        double amount = scanner.nextInt();

        boolean isDepositSuccess = accountService.deposit(account, amount);
        if(isDepositSuccess){
            System.out.println("Deposit Success :)");
        } else {
            System.out.println("account not exist");
        }
    }
}
