package main.dp907.ex2;

import main.dp907.ex1.NotificationFactory;

public class NotificationServiceImplV {

    public void sendNotification(String type, String message) {
        NotificationService notificationService = NotificationFactory.createNotification(type);
        notificationService.notify(message);
    }
}
