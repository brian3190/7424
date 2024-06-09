package com.example.assignment_group;

import java.util.ArrayList;
import java.util.List;

public class Restaurant{
    String username;
    String password;
    String name;
    String owner;
    String location;
    String category;
    String email;
    int phNumber;
    int bankNumber;

    List<FoodItem> menu;

    public Restaurant(String username, String password, String name, String owner, String location, String category, String email, int phNumber, int bankNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.owner = owner;
        this.location = location;
        this.category = category;
        this.email = email;
        this.phNumber = phNumber;
        this.bankNumber = bankNumber;
        this.menu = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(int phNumber) {
        this.phNumber = phNumber;
    }

    public int getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(int bankNumber) {
        this.bankNumber = bankNumber;
    }
}