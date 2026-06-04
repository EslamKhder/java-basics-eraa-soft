package main.dp910.iocdi.notification;

public class EmailNotificationService implements NotificationService {

    public void notifyUser(String sender, String message){
        System.out.println("send " + message + " to " + sender + " Email");
    }
}
