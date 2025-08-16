package main.ewallet907.service;

public interface ValidationService {

    boolean isUserNameValid(String userName);
    boolean isPasswordValid(String password);
    boolean isAgeValid(Integer age);
    boolean isPhoneNumberValid(String phoneNumber);
}
