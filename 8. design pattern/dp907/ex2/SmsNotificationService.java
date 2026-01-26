package main.dp907.ex2;

public class SmsNotificationService implements NotificationService {
    @Override
    public void notify(String message) {
        System.out.println("Sms send wit message : " + message);
    }
}
