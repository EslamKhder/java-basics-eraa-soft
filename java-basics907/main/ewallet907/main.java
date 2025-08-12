package main.ewallet907;


import main.ewallet907.service.ApplicationService;
import main.ewallet907.service.impl.ApplicationServiceImpl;


public class main {
    public static void main(String[] args) {

        ApplicationService applicationService = new ApplicationServiceImpl();
        applicationService.startApp();
    }

}
