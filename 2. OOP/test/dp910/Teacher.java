package main.dp910;

public class Teacher {
    private Integer id = 1;
    private String name = "ahmed";

    private Boolean connection;

    public Teacher(Boolean connection) {
        this.connection = connection;
    }

    public void printData(){
        if (connection == true) {
            System.out.println("id: " + id);
            System.out.println("name: " + name);
        }
    }
}
