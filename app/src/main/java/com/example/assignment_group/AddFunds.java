package com.example.assignment_group;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddFunds extends AppCompatActivity {
    EditText amountEditText;
    FirebaseDatabase database;
    DatabaseReference myRef = database.getReference("users");
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_funds);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        amountEditText = findViewById(R.id.amount);
    }

    public void addFundsToBalance(View view) {


        if (amountEditText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter an amount", Toast.LENGTH_SHORT).show();
        } else {
            try {
                double amount = Double.parseDouble(amountEditText.getText().toString());

            }
            catch (NumberFormatException e){
                Toast.makeText(this, "Please enter a valid amount", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void backToHome(View view) {
        finish();
    }
}