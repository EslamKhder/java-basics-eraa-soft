package main.dp910.iocdi;

import main.dp910.iocdi.notification.EmailNotificationService;
import main.dp910.iocdi.notification.NotificationService;
import main.dp910.iocdi.notification.PaypalNotificationService;
import main.dp910.iocdi.notification.SmsNotificationService;

public class NotificationControlService {


    private NotificationService notificationService;

    public NotificationControlService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void sendNotification(String sender, String message){
        notificationService.notifyUser(sender, message);
    }
}
