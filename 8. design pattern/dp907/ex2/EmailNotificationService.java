package main.dp907.ex2;

public class EmailNotificationService implements NotificationService {

    @Override
    public void notify(String message) {
        System.out.println("Email send wit message : " + message);
    }
}
