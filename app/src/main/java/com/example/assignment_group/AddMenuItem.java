package com.example.assignment_group;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.ref.Reference;

public class AddMenuItem extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference menuItemsRef = database.getReference("Restaurants");

    EditText edtFoodName, edtFoodPrice, edtFoodCategory, edtFoodDiscount, edtFoodDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_menu_item);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtFoodName = findViewById(R.id.txt_food_name);
        edtFoodPrice = findViewById(R.id.txt_food_price);
        edtFoodCategory = findViewById(R.id.txt_food_category);
        edtFoodDiscount = findViewById(R.id.txt_food_discount);
        edtFoodDescription = findViewById(R.id.txt_food_description);
    }

    public void addMenuItem(View view) {
        String foodName = edtFoodName.getText().toString();
        String foodPrice = edtFoodPrice.getText().toString();
        String foodCategory = edtFoodCategory.getText().toString();
        String foodDiscount = edtFoodDiscount.getText().toString();
        String foodDescription = edtFoodDescription.getText().toString();
        menuItemsRef.push().child("FoodName").setValue(new FoodItem(foodName, (int) Integer.parseInt(foodPrice), (int) Integer.parseInt(foodDiscount) , foodCategory, foodDescription));
    }

    public void cancel(View view) {
        finish();
    }
}