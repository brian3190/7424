package com.example.assignment_group.utils;

import com.example.assignment_group.models.CartModel;
import com.example.assignment_group.models.ItemModelClass;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class HelperUtils {

    public static  String generateUniqueID() {
        return UUID.randomUUID().toString();
    }

    public static String convertDateToStr(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(date);
        return  formattedDate;
    }


    //Function to create string
    public static String convertCartListToString(List<CartModel> cartItemList) {
        Gson gson = new Gson();
        return gson.toJson(cartItemList);
    }

    //function to create list from string
    public static List<CartModel> convertStringToCartList(String jsonString) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<CartModel>>() {}.getType();
        return gson.fromJson(jsonString, listType);
    }

    public static String convertItemListToString(List<ItemModelClass> cartItemList) {
        Gson gson = new Gson();
        return gson.toJson(cartItemList);
    }

    //function to create list from string
    public static List<ItemModelClass> convertStringToITemList(String jsonString) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<ItemModelClass>>() {}.getType();
        return gson.fromJson(jsonString, listType);
    }
}
