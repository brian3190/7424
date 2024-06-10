package com.example.assignment_group.models;

public class CartModel {

    String id;
    ItemModelClass item;

    double price;
    int qty;






    public CartModel(String id, ItemModelClass item, double price, int qty) {
        this.id = id;
        this.item = item;
        this.price = price;
        this.qty = qty;

    }

    public CartModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ItemModelClass getItem() {
        return item;
    }

    public void setItem(ItemModelClass item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    
}
