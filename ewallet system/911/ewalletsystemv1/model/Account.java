package main.g911.ewalletsystem.model;

public class Account {
    private String userName;
    private String password;
    private Double balance;
    private String phoneNumber;
    private float age;

    public Account() {
    }

    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Account(String userName, String password, String phoneNumber, float age) {
        this.userName = userName;
        this.password = password;
        this.balance = .0;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }
}
