package main1;

public class Student extends BaseEntity {


    void startConnection(){
        super.startConnection();

        userName = "ahmed";
        password = "123";
        System.out.println("ip: " + ip );
        System.out.println("port: " + port );
        System.out.println("userName: " + port );
        System.out.println("password: " + port );

    }
}
