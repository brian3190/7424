package com.example.assignment_group;

public class Customer {
    String firstName;
    String lastName;

    String userName;
    String Password;

    long phoneNumber;
    String email;
    String address;
    int bankAccount;

    public Customer(String firstName, String lastName, String userName, String password, long phoneNumber, String email, String address, int bankAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        Password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.bankAccount = bankAccount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(int bankAccount) {
        this.bankAccount = bankAccount;
    }
}
