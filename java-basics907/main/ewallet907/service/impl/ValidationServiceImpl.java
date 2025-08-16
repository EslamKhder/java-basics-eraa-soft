package main.ewallet907.service.impl;

import main.ewallet907.service.ValidationService;

public class ValidationServiceImpl implements ValidationService {
    @Override
    public boolean isUserNameValid(String userName) {
        /*
        * TODO validate username
        * TODO must start with uppercase
        * TODO size must be greater than or equal 7
        * TODO return true else return false
        */
        return false;
    }

    @Override
    public boolean isPasswordValid(String password) {
        /*
         * TODO validate password
         * TODO password must contain uppercase, lowercase, number , specialChar
         * TODO size must be greater than or equal 7
         * TODO return true else return false
         */
        return false;
    }

    @Override
    public boolean isAgeValid(Integer age) {
        /*
         * TODO validate age
         * TODO age must be greater than or equal 20
         * TODO return true else return false
         */
        return false;
    }

    @Override
    public boolean isPhoneNumberValid(String phoneNumber) {
        /* 201113903660
         * TODO validate phoneNumber
         * TODO phoneNumber must be start with 20
         * TODO size must equal 12
         * TODO return true else return false
         */
        return false;
    }
}
