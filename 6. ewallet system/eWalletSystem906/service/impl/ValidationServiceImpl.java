package main.eWalletSystem906.service.impl;

import main.eWalletSystem906.model.Account;
import main.eWalletSystem906.service.ValidationService;

import java.util.Scanner;

public class ValidationServiceImpl implements ValidationService {

    /**
     * check if username size >=3 and start with upper case
     * @param userName
     * @return
     */
    // 01234
    // eslam

    @Override
    public boolean isValidUserName(String userName) {
        if(userName.length() >=3 && Character.isUpperCase(userName.charAt(0))){
            return true;
        }
        return false;
    }

    // TODO
    /**
     * password
     *          - length must be greater than or equal 6
     *          - must contain upper case
     *          - must contain lower case
     *          - must contain number
     *          - must contain special char (#$@&)
     * @param password
     * @return
     */
    @Override
    public boolean isValidPassword(String password) {
        return true;
    }

    // TODO
    /**
     * age
     *      - must be between [18, 80]
     * @param age
     * @return
     */
    @Override
    public boolean isValidAge(int age) {
        return true;
    }

    // TODO
    /**
     * PhoneNumber      201113903660
     *         - must start with 2
     *         - length must be 12
     * @param phoneNumber
     * @return
     */
    @Override
    public boolean isValidPhoneNumber(String phoneNumber) {
        return true;
    }

    @Override
    public Account validateCreateAccount(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("pls enter user name");
        String userName = scanner.next();

        // validationService.isValidUserName(userName)   !true   !false
        if(!isValidUserName(userName)){
            System.out.println("invalid username.");
            System.out.println("username size must be greater than or equal 3 and start with upper case.");
            return null;
        }

        System.out.println("pls enter password");
        String password = scanner.next();
        if(!isValidPassword(password)){
            System.out.println("invalid password.");
            System.out.println("Password must be at least 6 characters long and include at least one uppercase letter, one lowercase letter, one number, and one special character from the following: #, $, @, &.");
            return null;
        }

        System.out.println("pls enter age");
        int age = scanner.nextInt();

        if(!isValidAge(age)){
            System.out.println("invalid age.");
            System.out.println("age must be between [18, 80].");
            return null;
        }

        System.out.println("pls enter phone number");
        String phoneNumber = scanner.next();
        if(!isValidPhoneNumber(phoneNumber)){
            System.out.println("phone number.");
            System.out.println("phone number must start with 2 and length must be 12.");
            return null;
        }

        return new Account(userName, password, phoneNumber, age);
    }

    // TODO
    @Override
    public Account validateLoginAccount() {
        return null;
    }
}
