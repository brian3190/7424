package com.example.assignment_group;

import android.content.Intent;
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

public class RegisterRestaurant extends AppCompatActivity {
    EditText edtUsername, edtPassword, edtName, edtOwner, edtLocation, edtCategory, edtEmail, edtPhNumber, edtBankNumber;
    FirebaseDatabase database;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_restaurant);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        edtUsername = findViewById(R.id.txt_restaurant_username);
        edtPassword = findViewById(R.id.txt_restaurant_password);
        edtName = findViewById(R.id.txt_restaurant_name);
        edtOwner = findViewById(R.id.txt_restaurant_owner);
        edtLocation = findViewById(R.id.txt_restaurant_location);
        edtCategory = findViewById(R.id.txt_restaurant_category);
        edtEmail = findViewById(R.id.txt_restaurant_email);
        edtPhNumber = findViewById(R.id.txt_restaurant_phNumber);
        edtBankNumber = findViewById(R.id.txt_restaurant_bankNumber);

    }



    public void registerRestaurant(View view) {
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        String name = edtName.getText().toString();
        String owner = edtOwner.getText().toString();
        String location = edtLocation.getText().toString();
        String category = edtCategory.getText().toString();
        String email = edtEmail.getText().toString();
        String phNumber = edtPhNumber.getText().toString();
        String bankNumber = edtBankNumber.getText().toString();
            if (username.isEmpty() || password.isEmpty()||name.isEmpty()||owner.isEmpty()||location.isEmpty()||category.isEmpty()||email.isEmpty()||phNumber.isEmpty()||bankNumber.isEmpty()) {
                Toast.makeText(this, "Please complete all fields", Toast.LENGTH_SHORT).show();
            }
            else {
                registerRestaurantUser(username, password);

                DatabaseReference myRef = database.getReference("Restaurants");
                FirebaseUser currentUser = mAuth.getCurrentUser();
                myRef.child(mAuth.getCurrentUser().getUid()).setValue(new Restaurant(username, password, name, owner, location, category, email, (int) Integer.parseInt(phNumber), (int) Integer.parseInt(bankNumber)));
                Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(this, RestaurantDashboard.class);
                intent.putExtra("name", name);
                startActivity(intent);

            }

    }
    public void registerRestaurantUser(String username, String password) {
        mAuth.createUserWithEmailAndPassword(username, password);
    }
    public void loginRestaurant(String username, String password) {
        mAuth.signInWithEmailAndPassword(username, password);
    }
}