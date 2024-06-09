package com.example.assignment_group.models;

import java.util.ArrayList;

public class MyOrdersmodel {

    String id;
    String orderId;
    ArrayList<String> productNames;
    ArrayList<Double> productPrices;
    ArrayList<Integer> productQuantities;
    ArrayList<Double> productTotals;
    String buyersAddress;
    String buyersCity;
    String buyersPincode;
    String buyersCardNumber;
    String buyersCvv;
    String buyersExpiryDate;
    double totalAmountl;

    public MyOrdersmodel(String id, String orderId, ArrayList<String> productNames, ArrayList<Double> productPrices, ArrayList<Integer> productQuantities, ArrayList<Double> productTotals, String buyersAddress, String buyersCity, String buyersPincode, String buyersCardNumber, String buyersCvv, String buyersExpiryDate, double totalAmountl) {
        this.id = id;
        this.orderId = orderId;
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
        this.totalAmountl = totalAmountl;
    }

    public MyOrdersmodel() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    @Override
    public String toString() {
        return "MyOrdersmodel{" +
                "id='" + id + '\'' +
                ", orderId='" + orderId + '\'' +
                ", productNames=" + productNames +
                ", productPrices=" + productPrices +
                ", productQuantities=" + productQuantities +
                ", productTotals=" + productTotals +
                ", buyersAddress='" + buyersAddress + '\'' +
                ", buyersCity='" + buyersCity + '\'' +
                ", buyersPincode='" + buyersPincode + '\'' +
                ", buyersCardNumber='" + buyersCardNumber + '\'' +
                ", buyersCvv='" + buyersCvv + '\'' +
                ", buyersExpiryDate='" + buyersExpiryDate + '\'' +
                ", totalAmountl=" + totalAmountl +
                '}';
    }
}
