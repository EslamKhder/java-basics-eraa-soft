package main.g911;

/*
* printData --> student
* printData --> BaseEntity
* */
// class extends class
// class extends abstract class
// interface extends interface
// interface extends interface, interface, interface, interface and interface
// class implements interface
// class implements interface, interface, interface and interface
public class Student implements BaseEntity {


    @Override
    public void start1() {
        System.out.println("start Student 1");
    }

    public void printStudent() {
        System.out.println("printStudent  data .");
    }


}
