package main.g911.ewalletsystem.service.impl;

import main.g911.ewalletsystem.service.ValidationService;

public class ValidationServiceImpl implements ValidationService  {

    @Override
    public boolean isUserNameValid(String userName) {  // Ahmed
        if (userName.isBlank()) {
            return false;
        }

        if (userName.length() < 3) {
            return false;
        }

        // TODO  username must be not contain number
        // TODO  username must start with char
        // TODO  username must start with upper

        return true;
    }

    @Override
    public boolean isPasswordValid(String password) {
        // TODO
        if (password.isBlank()) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }
        // TODO  password must be start with char , contain uppercase , lower case , digit and special char

        return true;
    }

    // TODO pls apply for all input you need
}
