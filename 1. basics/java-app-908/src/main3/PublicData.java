package main3;

public class PublicData extends BaseEntity{
    public int age;

    public PublicData() {
    }

    public PublicData(int id, String name, int age) {
        super(id, name);
        this.age = age;
    }

    void printData(){
        super.printShareData();
        System.out.println(age);
    }
}
