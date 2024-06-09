package com.example.assignment_group.shoppingcart;

import com.google.gson.Gson;

import java.util.ArrayList;

public class ComfirmOrderModel {


    String orderid;
    ArrayList<String> productNames;
    ArrayList<Double> productPrices;
    ArrayList<Integer> productQuantities;
    ArrayList<Double> productTotals;
    String buyersAddress; String buyersCity;
    String buyersPincode;
    String buyersCardNumber;
    String buyersCvv;
    String buyersExpiryDate;
    double totalAmountl;
    public ComfirmOrderModel(String orderid,ArrayList<String> productNames, ArrayList<Double> productPrices, ArrayList<Integer> productQuantities, ArrayList<Double> productTotals, String buyersAddress, String buyersCity, String buyersPincode, String buyersCardNumber, String buyersCvv, String buyersExpiryDate, double totalAmount) {

        this.orderid = orderid;
        this.productNames = productNames;
        this.productPrices = productPrices;
        this.productQuantities = productQuantities;
        this.productTotals = productTotals;
        this.buyersAddress = buyersAddress;
        this.buyersCity = buyersCity;
        this.buyersPincode = buyersPincode;
        this.buyersCardNumber = buyersCardNumber;
        this.buyersCvv = buyersCvv;
        this.buyersExpiryDate = buyersExpiryDate;
        this.totalAmountl = totalAmount;


    }

    public ComfirmOrderModel() {
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public ArrayList<String> getProductNames() {
        return productNames;
    }

    public void setProductNames(ArrayList<String> productNames) {
        this.productNames = productNames;
    }

    public ArrayList<Double> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(ArrayList<Double> productPrices) {
        this.productPrices = productPrices;
    }

    public ArrayList<Integer> getProductQuantities() {
        return productQuantities;
    }

    public void setProductQuantities(ArrayList<Integer> productQuantities) {
        this.productQuantities = productQuantities;
    }

    public ArrayList<Double> getProductTotals() {
        return productTotals;
    }

    public void setProductTotals(ArrayList<Double> productTotals) {
        this.productTotals = productTotals;
    }

    public String getBuyersAddress() {
        return buyersAddress;
    }

    public void setBuyersAddress(String buyersAddress) {
        this.buyersAddress = buyersAddress;
    }

    public String getBuyersCity() {
        return buyersCity;
    }

    public void setBuyersCity(String buyersCity) {
        this.buyersCity = buyersCity;
    }

    public String getBuyersPincode() {
        return buyersPincode;
    }

    public void setBuyersPincode(String buyersPincode) {
        this.buyersPincode = buyersPincode;
    }

    public String getBuyersCardNumber() {
        return buyersCardNumber;
    }

    public void setBuyersCardNumber(String buyersCardNumber) {
        this.buyersCardNumber = buyersCardNumber;
    }

    public String getBuyersCvv() {
        return buyersCvv;
    }

    public void setBuyersCvv(String buyersCvv) {
        this.buyersCvv = buyersCvv;
    }

    public String getBuyersExpiryDate() {
        return buyersExpiryDate;
    }

    public void setBuyersExpiryDate(String buyersExpiryDate) {
        this.buyersExpiryDate = buyersExpiryDate;
    }

    public double getTotalAmountl() {
        return totalAmountl;
    }

    public void setTotalAmountl(double totalAmountl) {
        this.totalAmountl = totalAmountl;
    }

    public String toJsonString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static ComfirmOrderModel decodeConfirmModelFromJson(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, ComfirmOrderModel.class);
    }

}
