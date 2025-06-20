package main.eWalletSystem906.service;

import main.eWalletSystem906.model.Account;

public interface ValidationService {

    boolean isValidUserName(String userName);
    boolean isValidPassword(String password);
    boolean isValidAge(int age);
    boolean isValidPhoneNumber(String phoneNumber);

    Account validateCreateAccount();
    Account validateLoginAccount();
}
