package main.eWalletSystem906.model;

public class Account {

    private String userName;
    private String password;
    private double balance;
    private String phoneNumber;
    private Integer age;

    public Account() {
    }

    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public Account(String userName, String password, String phoneNumber, Integer age) {
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.balance = 0;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
