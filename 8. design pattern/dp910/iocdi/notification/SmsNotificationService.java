package main.dp910.iocdi.notification;

public class SmsNotificationService implements NotificationService{

    public void notifyUser(String sender, String message){
        System.out.println("send " + message + " to " + sender + " SMS");
    }
}
