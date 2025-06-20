package main.eWalletSystem906.service.impl;

import main.eWalletSystem906.model.Account;
import main.eWalletSystem906.service.AccountService;
import main.eWalletSystem906.service.ApplicationService;
import main.eWalletSystem906.service.ValidationService;

import java.util.Objects;
import java.util.Scanner;

public class ApplicationServiceImpl implements ApplicationService {

    private Scanner scanner = new Scanner(System.in);

    private AccountService accountService = new AccountServiceImpl();
    private ValidationService validationService = new ValidationServiceImpl();

    @Override
    public void startEWalletSystem() {
        System.out.println("Welcome sir :) ");
        int counter = 4;
        while (counter != 0) {
            System.out.println("please choose.");
            System.out.println("1.signup     2.login");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    signUp();
                    break;
                case 2:
                    login();
                    break;
                default:
                    counter--;
                    System.out.println("Invalid choose");
            }
            if (counter == 0){
                System.out.println("multi invalid choose please try later.");
            }
        }
    }

    /**
     * this function for login
     */
    private void login() {
        // TODO APPlY Validation for only username and password
        System.out.println("pls enter user name");
        String userName = scanner.next();

        System.out.println("pls enter password");
        String password = scanner.next();

        Account account = new Account(userName, password);
        boolean isLogin = accountService.login(account);
        if (isLogin) {
            System.out.println("Login Success :)");
            loginFeatures(account);
        } else {
            System.out.println("invalid username or password :(");
        }
    }

    // TODO change password feature
    // TODO transfer feature
    private void loginFeatures(Account account) {
        int counter = 4;
        boolean isUserLogout = false;
        while (counter != 0) {
            System.out.println("please choose.");
            System.out.println("1.deposit   2.withdraw   3.transfer   4.show Account details  5.change password  6.logout");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    deposit(account);
                    break;
                case 2:
                    withdraw(account);
                    break;
                case 3:
                    // TODO
                    break;
                case 4:
                    showAccountDetails(account);
                    break;
                case 5:
                    // TODO
                    break;
                case 6:
                    System.out.println("Have a nice Day :)");
                    isUserLogout = true;
                    break;
                default:
                    counter--;
                    System.out.println("Invalid choose");
            }
            if (counter == 0){
                System.out.println("multi invalid choose please try later.");
            }

            if (isUserLogout) {
                break;
            }
        }
    }

    private void withdraw(Account account) {
        System.out.println("please enter money you need to withdraw");
        double money = scanner.nextDouble();
        int withdrawSuccess = accountService.withDraw(account, money);

        if (withdrawSuccess == 3) {
            System.out.println("withdraw success :)");
        } else if (withdrawSuccess == 1){ // case false
            System.out.println("account not exist to withdraw :(");
        } else {
            System.out.println("your money you need to withdraw is greater than balance of account :(");
        }
    }

    private void showAccountDetails(Account account) {
        account = accountService.getAccount(account);
        if(Objects.isNull(account)){
            System.out.println("account not exist to show profile details");
            return;
        }

        System.out.println("-> userName:     " + account.getUserName());
        System.out.println("-> password:     " + account.getPassword());
        System.out.println("-> age:          " + account.getAge());
        System.out.println("-> phone number: " + account.getPhoneNumber());
        System.out.println("-> Balance:      " + account.getBalance());
    }

    private void deposit(Account account) {
        System.out.println("please enter money you need to deposit");
        double money = scanner.nextDouble();

        boolean depositSuccess = accountService.deposit(account, money);
        if (depositSuccess) {
            System.out.println("deposit success :)");
        } else {
            System.out.println("Account you need to deposit on it not found :(");
        }
    }

    /**
     * this function for signUp
     */
    private void signUp() {
        Account account = validationService.validateCreateAccount();
        if(Objects.isNull(account)){
            return;
        }
        boolean isAccountCreated = accountService.createAccount(account);
        if (isAccountCreated) {
            System.out.println("Account Created Success :)");
        } else {
            System.out.println("there exist Account with same user name:(");
        }
    }



    /**
     * boolean isUserNameValid = false;
     *         String userName = null;
     *         do {
     *             System.out.println("pls enter user name");
     *              userName = scanner.next();
     *
     *             isUserNameValid = validationService.isValidUserName(userName);
     *             // true     false
     *             if (!isUserNameValid) {
     *                 System.out.println("invalid username.");
     *                 System.out.println("username size must be greater than or equal 3 and start with upper case.");
     *             }
     *         } while (!isUserNameValid);
     */
}
