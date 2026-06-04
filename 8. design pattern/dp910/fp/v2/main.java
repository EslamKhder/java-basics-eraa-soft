package main.dp910.fp.v2;

import main.dp910.fp.v1.PizzaStoreV1;

public class main {
    public static void main(String[] args) {
        String type = "sms";
        Notification notification = NotificationFactory.createNotification(type);
        notification.notifyUser("hello");

    }

}
