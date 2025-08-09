package main3;

public class BaseEntity {

    public int id;
    public String name;

    public BaseEntity() {
    }

    public BaseEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void printShareData(){
        System.out.println(id);
        System.out.println(name);
    }
}
