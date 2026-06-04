package main.dp910.iocdi;

import main.dp910.iocdi.notification.EmailNotificationService;
import main.dp910.iocdi.notification.PaypalNotificationService;
import main.dp910.iocdi.notification.SmsNotificationService;
import main.dp910.iocdi.notification.XyzNotificationService;
import main.dp910.singlton.DBConnection;
import main.dp910.singlton.Student;

public class main {
    public static void main(String[] args) {
        NotificationControlService notificationControlService = new NotificationControlService(new SmsNotificationService());
        notificationControlService.sendNotification("011", "hi"); // sms

        notificationControlService = new NotificationControlService(new EmailNotificationService());
        notificationControlService.sendNotification("eslam@gmail.com", "hi"); // email

        notificationControlService = new NotificationControlService(new PaypalNotificationService());
        notificationControlService.sendNotification("23354", "hi"); // paypal

        notificationControlService = new NotificationControlService(new XyzNotificationService());
        notificationControlService.sendNotification("23354", "hi"); // paypal


    }

}
