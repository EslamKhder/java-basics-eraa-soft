package main3;

public class Player extends PublicData{
    public String thNumber;

    public Player(int id, String name,int age, String thNumber) {
        super(id, name,age);
        this.thNumber = thNumber;
    }

    void printPlayereData(){
        super.printData();
        System.out.println(thNumber);
    }
}
