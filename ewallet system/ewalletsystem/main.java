package main.g911.ewalletsystem;


import main.g911.ewalletsystem.service.impl.EWalletApplicationServiceImpl;

import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IllegalAccessException {
        new EWalletApplicationServiceImpl().start();
    }
}