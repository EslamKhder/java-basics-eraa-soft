package main.v1;

// class
// object
// access mod
// contractor
public class main {
    public static void main(String[] args) {

        Student student1 = new Student();
        student1.openConnection("admin", "admin@123");
        student1.getDataFromDB();

        Student student2 = new Student("admin", "admin@123");
        student2.getDataFromDB();



//        Student student1 = new Student("admin", "admin@123");
//        student1.getDataFromDB(); //
//
//        System.out.println("-------");
//
//        Student student2 = new Student("admin", "admin@123");
//        student2.getDataFromDB();//



//        Student student2 = new Student(5);
//        Student student3 = new Student(5, "AHMED");
//
//        System.out.println(student1.id);
//        System.out.println(student2.id);
//        System.out.println(student3.id);
    }

//    static void print(){
//        return;
//    }

}
