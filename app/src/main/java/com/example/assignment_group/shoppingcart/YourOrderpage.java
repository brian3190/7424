package com.example.assignment_group.shoppingcart;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.assignment_group.adapter.MyOrdesAdapters;
import com.example.assignment_group.callbacks.OnSuccessListner;
import com.example.assignment_group.databinding.ActivityYourOrderpageBinding;
import com.example.assignment_group.models.MyOrdersmodel;
import com.example.assignment_group.shoppingcart.ComfirmOrderModel;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class YourOrderpage extends AppCompatActivity {

    private static final String TAG = "YourOrderpage";
    private ActivityYourOrderpageBinding binding;
    private ArrayList<ComfirmOrderModel> myOrdersList = new ArrayList<>();
    private FirebaseFirestore db;
    private CollectionReference ordersCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityYourOrderpageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = FirebaseFirestore.getInstance();
        ordersCollection = db.collection("orders");

        binding.backButton.setOnClickListener(v -> finish());

        getOrdersFromDb(() -> {
            Toast.makeText(YourOrderpage.this, "Orders loaded successfully", Toast.LENGTH_SHORT).show();
            initMyOrdersList();
        });
    }

    private void initMyOrdersList() {
        MyOrdesAdapters myOrdesAdapters = new MyOrdesAdapters(myOrdersList, this);
        binding.orderRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.orderRecyclerView.setAdapter(myOrdesAdapters);
    }

    public void getOrdersFromDb(OnSuccessListner successListener) {
        ordersCollection.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                myOrdersList.clear();
                for (DocumentSnapshot document : task.getResult()) {
                    ComfirmOrderModel order = document.toObject(ComfirmOrderModel.class);
                    Log.e(TAG, "getOrdersFromDb: " + order.getOrderid() );
                    if (order != null) {
                        myOrdersList.add(order);
                    }
                }
                successListener.onSuccess();
            } else {
                Log.e(TAG, "Error getting documents.", task.getException());
                Toast.makeText(this, "Error getting orders", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
