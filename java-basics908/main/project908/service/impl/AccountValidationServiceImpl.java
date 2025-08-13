package main.project908.service.impl;

import main.project908.service.AccountValidationService;

public class AccountValidationServiceImpl implements AccountValidationService {

    @Override
    public boolean isUserNameValid(String userName) {
        // TODO name must start with Upper case
        // TODO name size must be >= 3
        return false;
    }

    @Override
    public boolean isPasswordValid(String password) {
        // TODO password must include upper case, lower case , number , [@#$%&^*_+)(!]
        // TODO password size must be >= 10
        return false;
    }

    @Override
    public boolean isPhoneNumberValid(String phoneNumber) {
        // TODO phoneNumber must must start with 20
        // TODO phoneNumber size must be = 12
        return false;
    }
}
