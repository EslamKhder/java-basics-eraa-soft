package main.ewalletSystem.service.impl;

import main.ewalletSystem.service.AccountValidationService;

public class AccountValidationServiceImpl implements AccountValidationService {
    @Override
    public boolean validateUserName(String userName) {
        if (userName.length() < 3) {
            return false;
        }
        // TODO @#$%^&*()_+
        return true;
    }

    @Override
    public boolean validatePassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        // TODO upper case , lower case , spec char, digit
        return true;
    }
}
