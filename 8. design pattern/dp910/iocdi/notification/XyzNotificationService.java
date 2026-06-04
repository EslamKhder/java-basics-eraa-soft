package main.dp910.iocdi.notification;

public class XyzNotificationService implements NotificationService {

    public void notifyUser(String sender, String message){
        System.out.println("send " + message + " to " + sender + " Email");
    }
}
