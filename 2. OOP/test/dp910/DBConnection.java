package main.dp910;

public class DBConnection {
    private Boolean connection;

    private static DBConnection dbConnection = null; //[new obj]

    private DBConnection() {
        openConnection();
    }

    public static DBConnection createObject(){
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    private void openConnection(){
        System.out.println("start open connection");
        connection = true; // 5 sec
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end open connection");
    }

    public Boolean getConnection() {
        return connection;
    }
}
