package main.v1;

// class 1 word  Student
// class 2 word  StudentSchool
// class 3 word  StudentSchoolClass

// attr  1 word  id
// attr  2 word  idSchool
// attr  3 word  idStudentSchool
// access mod
public class Student {

    private int id;
    private String name;
    private boolean connection = false;

    public Student() {
    }

    //
    public Student(String userName, String password) {
        openConnection(userName, password);
    }


    public void getDataFromDB(){
        if (connection) {
            id = 1;
            name = "ahmed";
            System.out.println("id : " + id);
            System.out.println("name : " + name);
        } else {
            System.out.println("pls connect with db");
        }
    }

    public void openConnection(String userName, String password){
        if (userName.equals("admin") && password.equals("admin@123")) {
            connection = true;
            System.out.println("Connected success :)..");
        } else {
            connection = false;
            System.out.println("Connected failed :(..");
        }
    }

}
