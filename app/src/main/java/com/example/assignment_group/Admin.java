package com.example.assignment_group;

public class Admin{
    String email;
    String password;
    String userType;


    public Admin() {
    }

    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
        this.userType = "Admin";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
=======


}