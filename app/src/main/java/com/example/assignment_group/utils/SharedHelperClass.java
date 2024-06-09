package com.example.assignment_group.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.assignment_group.models.CartModel;

import java.util.List;

public class SharedHelperClass {

    private static final String SHARED_PREFS_NAME = "user_prefs";
    private static final String PREF_CART_LIST = "cart_list";

    private final SharedPreferences prefs;

    public SharedHelperClass(Context context) {
        prefs = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
    }

  public  void saveCartList(List<CartModel> cartList){
      SharedPreferences.Editor editor = prefs.edit();
      String list = HelperUtils.convertCartListToString(cartList);
      editor.putString(PREF_CART_LIST, list);
      editor.apply();
    }

    public  List<CartModel> getCartList(){
        String list = prefs.getString(PREF_CART_LIST,"[]");
        List<CartModel> cartList = HelperUtils.convertStringToCartList(list);
        return cartList;
    }

}
