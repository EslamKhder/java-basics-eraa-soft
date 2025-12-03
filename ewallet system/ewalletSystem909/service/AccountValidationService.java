package main.ewalletSystem.service;

public interface AccountValidationService {

    boolean validateUserName(String userName);
    boolean validatePassword(String password);
}
