package main1;

public abstract class BaseEntity {

    String ip = null;
    String port = null;
    String userName = null;
    String password = null;

    void startConnection(){
        // ip  port
        ip = "127.2.2.2";
        port = "1572";
    }

}
