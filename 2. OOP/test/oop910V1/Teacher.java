package main.oop910V1;

public class Teacher extends Student implements TestInterface {

    @Override
    public void print() {
        System.out.println("Teacher hi");
    }
}
