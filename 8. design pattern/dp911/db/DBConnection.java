package main.dp911.db;

import java.util.Objects;

// DBConnection dbConnection1 = DBConnection.createObject();
// DBConnection dbConnection2 = DBConnection.createObject();
// DBConnection dbConnection3 = DBConnection.createObject();
public class DBConnection {

    private Boolean connection = false;

    private static DBConnection dbConnection = null;

    public static DBConnection createObject(){
        if (Objects.isNull(dbConnection)) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    private DBConnection() {
    }

    public Boolean getConnection() {
        return connection;
    }

    public boolean createConnection(String userName, String password){
        if (userName != "HR" || password != "HR") {
            System.out.println("invalid username or password failed to connect");
            return false;
        }

        if (connection == true) {
            return true;
        }

        System.out.println("start connect with db");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connected to db success...");
        connection = true;
        return true;
    }
}
