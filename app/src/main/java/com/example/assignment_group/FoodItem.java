package com.example.assignment_group;

public class FoodItem {
    String foodName;
    int foodPrice;
    int discount;
    String availabitlity;
    String Description;
    String image;
    String category;

    public FoodItem(String foodName, int foodPrice, int discount, String availabitlity, String description, String image, String category) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.discount = discount;
        this.availabitlity = availabitlity;
        this.Description = description;
        this.image = image;
        this.category = category;
    }

    public FoodItem(String foodName, int foodPrice, int discount, String category, String description){
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.discount = discount;
        this.category = category;
        this.Description = description;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getAvailabitlity() {
        return availabitlity;
    }

    public void setAvailabitlity(String availabitlity) {
        this.availabitlity = availabitlity;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
