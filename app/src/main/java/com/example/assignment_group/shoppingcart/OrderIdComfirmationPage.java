package com.example.assignment_group.shoppingcart;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.assignment_group.R;
import com.example.assignment_group.databinding.ActivityCartViewPageBinding;
import com.example.assignment_group.databinding.ActivityOrderIdComfirmationPageBinding;

import java.util.List;

public class OrderIdComfirmationPage extends AppCompatActivity {

    private ActivityOrderIdComfirmationPageBinding binding;

    private ComfirmOrderModel orderModel;

    public  String TAG = "OrderIdComfirmationPage";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderIdComfirmationPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        Intent i = getIntent();
        if (i.getExtras() != null){
            orderModel = ComfirmOrderModel.decodeConfirmModelFromJson(i.getStringExtra("order"));
            Log.e(TAG, "onCreate: " + orderModel.getOrderid() );
        }

        String productName = formatList(orderModel.getProductNames());
        String getOrderid = String.valueOf(orderModel.getOrderid());
        String getProductQuantities = formatList(orderModel.getProductQuantities());
        String getProductPrices = formatList(orderModel.getProductPrices());
        String getProductTotals = formatList(orderModel.getProductTotals());
        String getTotalAmount = String.valueOf(orderModel.getTotalAmountl());
        String getBuyersAddress = orderModel.getBuyersAddress();

        // Set product name, ID, quantity, price, and total amount
        binding.PoductName.setText(productName);
      //  binding.productId.setText(getOrderid);
        binding.productQty.setText(getProductQuantities);
        binding.productPrice.setText(getProductPrices);
        binding.ProductTotal.setText(getProductTotals);
        binding.productNetAmont.setText(getTotalAmount);
        binding.tvAddress.setText(getBuyersAddress);


        binding.imgBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

    }
    private String formatList(List<?> list) {
        StringBuilder formattedString = new StringBuilder();
        for (Object item : list) {
            formattedString.append(item.toString()).append("\n");
        }
        return formattedString.toString();
    }
}