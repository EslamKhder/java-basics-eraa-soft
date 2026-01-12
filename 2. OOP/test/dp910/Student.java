package main.dp910;

public class Student {
    private Integer id = 1;
    private String name = "ahmed";

    private Boolean connection;

    public Student(Boolean connection) {
        this.connection = connection;
    }

    public void printData(){
        if (connection == true) {
            System.out.println("id: " + id);
            System.out.println("name: " + name);
        }
    }
}
