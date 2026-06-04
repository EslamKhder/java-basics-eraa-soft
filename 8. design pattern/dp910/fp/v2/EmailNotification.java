package main.dp910.fp.v2;

public class EmailNotification implements Notification{

    @Override
    public void notifyUser(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}
