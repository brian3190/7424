package com.example.assignment_group.shoppingcart;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment_group.R;
import com.example.assignment_group.databinding.ActivityComfirmOrderBinding;
import com.example.assignment_group.utils.HelperUtils;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class ComfirmOrder extends AppCompatActivity {

    private ActivityComfirmOrderBinding binding;
    int nettotalPrice;

    private FirebaseFirestore db;
    private CollectionReference ordersCollection;

    ArrayList<ComfirmOrderModel> comfirmOrderModels = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comfirm_order);
        binding = ActivityComfirmOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = FirebaseFirestore.getInstance();
        ordersCollection = db.collection("orders");

        Intent intent = getIntent();
        double totalAmount = intent.getDoubleExtra("totalAmount", 0.0);

        Log.e("ghjwjhjk","totalAmount :"+totalAmount);
        ArrayList<String> productNames = intent.getStringArrayListExtra("product_names");
        ArrayList<Double> productPrices = (ArrayList<Double>) intent.getSerializableExtra("product_prices");
        ArrayList<Integer> productQuantities = (ArrayList<Integer>) intent.getSerializableExtra("product_quantities");
        ArrayList<Double> productTotals = (ArrayList<Double>) intent.getSerializableExtra("product_totals");





        binding.tvProductName.setText(formatList(productNames));
        binding.tvTotalQty.setText(formatList(productQuantities));
        binding.tvprice.setText(formatList(productPrices));
        binding.tvtotalprice.setText(formatList(productTotals));
        binding.tvNetAmount.setText(String.valueOf(totalAmount));
        binding.tvNetAmount.setText("$" + String.valueOf(totalAmount));

        binding.placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // address details
                String buyersAddress = binding.edAddress.getText().toString().trim();
                String buyersCity = binding.edState.getText().toString().trim();
                String buyersPincode = binding.edPincode.getText().toString().trim();

                // payment details
                String buyersCardNumber = binding.edCardNumber.getText().toString().trim();
                String buyersCvv = binding.edCVV.getText().toString().trim();
                String buyersExpiryDate = binding.edExpiryDate.getText().toString().trim();

                if (TextUtils.isEmpty(buyersAddress) || TextUtils.isEmpty(buyersCity) ||
                        TextUtils.isEmpty(buyersPincode) || TextUtils.isEmpty(buyersCardNumber) ||
                        TextUtils.isEmpty(buyersCvv) || TextUtils.isEmpty(buyersExpiryDate)) {

                    Toast.makeText(ComfirmOrder.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {

                    String id = HelperUtils.generateUniqueID();
                    ComfirmOrderModel orderModel = new ComfirmOrderModel(
                            id, productNames, productPrices, productQuantities, productTotals,
                            buyersAddress, buyersCity, buyersPincode,
                            buyersCardNumber, buyersCvv, buyersExpiryDate,
                            totalAmount
                    );





                    // Add the orderModel to Firestore
                    ordersCollection.document(orderModel.getOrderid())
                            .set(orderModel)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d("ComfirmOrder", "DocumentSnapshot added with ID: " + orderModel.getOrderid());
                                    Toast.makeText(ComfirmOrder.this, "Order placed successfully!", Toast.LENGTH_SHORT).show();

                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                    Log.w("ComfirmOrder", "Error adding document", e);
                                    Toast.makeText(ComfirmOrder.this, "Failed to place order. Please try again.", Toast.LENGTH_SHORT).show();

                                }
                            });
                }
            }
        });

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