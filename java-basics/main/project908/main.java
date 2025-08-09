package main.project908;

import main.project908.service.AccountService;
import main.project908.service.ApplicationService;
import main.project908.service.impl.AccountServiceImpl;
import main.project908.service.impl.EWalletServiceImpl;

public class main {
    public static void main(String[] args) {
        ApplicationService applicationService = new EWalletServiceImpl();
        applicationService.startApp();
    }
}
