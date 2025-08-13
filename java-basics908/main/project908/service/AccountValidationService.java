package main.project908.service;

public interface AccountValidationService {

    boolean isUserNameValid(String userName);
    boolean isPasswordValid(String password);
    boolean isPhoneNumberValid(String phoneNumber);
}
