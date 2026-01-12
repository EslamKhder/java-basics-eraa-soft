package main.dp910;

public class main {
    public static void main(String[] args) {
        Student student1 = new Student(DBConnection.createObject().getConnection());
        student1.printData();

        Student student2 = new Student(DBConnection.createObject().getConnection());
        student2.printData();

        Teacher teacher = new Teacher(DBConnection.createObject().getConnection());
        teacher.printData();
    }
}
