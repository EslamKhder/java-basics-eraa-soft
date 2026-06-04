package main.dp910.fp.v2;

public class SmsNotification implements Notification{

    @Override
    public void notifyUser(String message) {
        System.out.println("Sending Sms: " + message);
    }
}
