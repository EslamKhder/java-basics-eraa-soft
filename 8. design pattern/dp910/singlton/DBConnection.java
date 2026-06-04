package main.dp910.singlton;

import java.util.Objects;

public class DBConnection {
    private Boolean connection = false;

    private static DBConnection dbConnection;

    private DBConnection() {
    }

    // createObject() 1
    // createObject() 2

    // create fun create object
    public static DBConnection createObject(){
        if (Objects.isNull(dbConnection)){
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public void openConnection(String userName, String password){
        if(connection == true){
            return;
        }

        System.out.println("start open connection.....");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (userName.equals("admin") && password.equals("admin@123")) {
            connection = true;
            System.out.println("Connection Open Success");
        } else {
            connection = false;
            System.out.println("Connection Failed");
        }
    }

    public Boolean getConnection() {
        return connection;
    }
}
