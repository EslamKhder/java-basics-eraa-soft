package main.dp910.ex;

import main.dp910.iocdi.NotificationControlService;
import main.dp910.iocdi.notification.EmailNotificationService;
import main.dp910.iocdi.notification.PaypalNotificationService;
import main.dp910.iocdi.notification.SmsNotificationService;
import main.dp910.iocdi.notification.XyzNotificationService;

public class main {
    public static void main(String[] args) {
        ItemControlService itemControlService = new ItemControlService(new ItemServiceOrImpl());

        itemControlService.getAllItems();

        itemControlService = new ItemControlService(new ItemServiceMySQLImpl());

        itemControlService.getAllItems();
    }

}
