package main.g911.ewalletsystem.service;

public interface ValidationService {

    boolean isUserNameValid(String userName);
    boolean isPasswordValid(String password);
}
