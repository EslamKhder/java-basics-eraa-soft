package main.ewallet907.service.impl;

import main.ewallet907.service.ApplicationService;

import java.util.Scanner;

public class ApplicationServiceImpl implements ApplicationService {
    @Override
    public void startApp() {
        System.out.println("---------- hello sir -------------");

        int counter = 0;
        while (true) {
            boolean isExit = false;

            System.out.println("pls enter what you need to do?!");
            System.out.println("1.login              2.signup            3.Exit");
            Scanner scanner = new Scanner(System.in);
            int res = scanner.nextInt();

            switch (res) {
                case 1:
                    System.out.println("i am login");
                    break;
                case 2:
                    System.out.println("i am signup");
                    break;
                case 3:
                    System.out.println("have a nice day :)");
                    isExit = true;
                    break;
                default:
                    System.out.println("Invalid input :(");
                    counter++;
            }

            if(isExit){
                break;
            }

            if(counter == 4){
                System.out.println("pls try on last time :(");
                break;
            }
        }
    }
}
