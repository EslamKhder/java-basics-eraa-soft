package main.dp910.fp.v2;

public class PushNotification implements Notification{

    @Override
    public void notifyUser(String message) {
        System.out.println("Sending Push: " + message);
    }
}
