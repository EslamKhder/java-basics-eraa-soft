package main.g911;

public interface SchoolService {


    void addStudent();

    default void removeStudent() {
        System.out.println("removeStudent..");
    }

    static void getStudent() {
        System.out.println("getStudent..");
    }


}
