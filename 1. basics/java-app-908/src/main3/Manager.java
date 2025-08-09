package main3;

public class Manager extends BaseEntity{
    String address;


    void printManagerData(){
        super.printShareData();
        System.out.println(address);
    }
}
