package main.g911;

public class BaseEntity {
    private int id;
    private String name;


    public BaseEntity() {
        System.out.println("i am on BaseEntity con");
    }

    public BaseEntity(int x) {
        System.out.println("i am on BaseEntity con with x " + x);
    }

    public BaseEntity(String name) {
        System.out.println("i am on BaseEntity con with name " + name);
    }
    public BaseEntity(String name, String phone) {
        System.out.println("i am on BaseEntity con with name " + name + " phone " + phone);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
