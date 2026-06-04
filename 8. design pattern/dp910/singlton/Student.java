package main.dp910.singlton;

import java.util.Objects;

public class Student {

    private DBConnection dbConnection;

    public void printData(){
        if (Objects.nonNull(dbConnection) && dbConnection.getConnection()) {
            System.out.println("-------> Student Data : <--------");
            System.out.println("id: " + 1);
            System.out.println("name: ahmed");
            System.out.println("age: " + 20);
        } else {
            System.out.println("no connection found pls connect with db first...");
        }

    }

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public int getId(){
        return 1;
    }
}
