package main.g911;

public class main {
    public static void main(String[] args) throws IllegalAccessException {

        BaseEntity baseEntity = new Employee();
        baseEntity.start1();//

        baseEntity = new Teacher();
        baseEntity.start1();//

        baseEntity = new Student();
        baseEntity.start1();


    }
}
