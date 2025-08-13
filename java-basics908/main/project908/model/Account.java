package main.project908.model;

public class Account {
    private String userName;
    private String password;
    private String phoneNumber;
    private Double balance;

    public Account() {
    }

    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public Account(String userName, String password, String phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.balance = 0D;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
