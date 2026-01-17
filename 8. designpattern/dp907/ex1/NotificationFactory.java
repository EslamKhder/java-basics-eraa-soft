package main.dp907.ex1;

import main.dp907.ex2.EmailNotificationService;
import main.dp907.ex2.NotificationService;
import main.dp907.ex2.PushNotificationService;
import main.dp907.ex2.SmsNotificationService;

public class NotificationFactory {

    public static NotificationService createNotification (String type){
        NotificationService notificationService = null;
        if (type.equals("email")) {
            notificationService = new EmailNotificationService();
        } else if (type.equals("sms")) {
            notificationService = new SmsNotificationService();
        } else if (type.equals("push")) {
            notificationService = new PushNotificationService();
        } else {
            throw new RuntimeException("Unknown type");
        }

        return notificationService;
    }
}
