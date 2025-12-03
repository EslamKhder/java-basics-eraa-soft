package main.ewalletSystem;

import main.ewalletSystem.service.ApplicationService;
import main.ewalletSystem.service.impl.EWalletServiceImpl;

public class main {
    public static void main(String[] args) {
        ApplicationService applicationService = new EWalletServiceImpl();
        applicationService.startApp();

    }

}
