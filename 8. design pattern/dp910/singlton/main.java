package main.dp910.singlton;

public class main {
    public static void main(String[] args) {


//        // Ex1
        System.out.println("------------------ Ex1 ------------------");
//        DBConnection dbConnection1 = new DBConnection();
        DBConnection dbConnection1 = DBConnection.createObject();
        dbConnection1.openConnection("admin", "admin@123");

        Student student1 = new Student();
        student1.setDbConnection(dbConnection1);
        student1.printData();


        // Ex2
        System.out.println("------------------ Ex2 ------------------");
//        DBConnection dbConnection2 = new DBConnection();
        DBConnection dbConnection2 = DBConnection.createObject();
        dbConnection2.openConnection("admin", "admin@123");

        Student student2 = new Student();
        student2.setDbConnection(dbConnection2);
        student2.printData();

        // Ex2
        System.out.println("------------------ Ex3 ------------------");
//        DBConnection dbConnection3 = new DBConnection();
        DBConnection dbConnection3 = DBConnection.createObject();;
        dbConnection3.openConnection("admin", "admin@123");

        Student student3 = new Student();
        student3.setDbConnection(dbConnection3);
        student3.printData();
//
//
//
//
//
//

    }

}
