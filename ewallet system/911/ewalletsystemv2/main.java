package main.g911.ewalletsystem;


import main.g911.ewalletsystem.service.AccountService;
import main.g911.ewalletsystem.service.impl.AccountServiceImpl;
import main.g911.ewalletsystem.service.impl.EWalletApplicationServiceImpl;

import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IllegalAccessException {
        AccountService accountService = new AccountServiceImpl();
        new EWalletApplicationServiceImpl().start();
    }
}