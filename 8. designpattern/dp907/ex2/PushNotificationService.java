package main.dp907.ex2;

public class PushNotificationService implements NotificationService {
    @Override
    public void notify(String message) {
        System.out.println("push send wit message : " + message);
    }
}
