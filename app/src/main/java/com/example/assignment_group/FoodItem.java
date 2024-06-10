package com.example.assignment_group;

public class FoodItem {
    String foodName;
    int foodPrice;
    int discount;

    String description;
    //String image;
    String category;

    public FoodItem(String foodName, int foodPrice, int discount, String category, String description){
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.discount = discount;
        this.category = category;
        this.description = description;
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



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
