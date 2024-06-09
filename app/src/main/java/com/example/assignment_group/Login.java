package com.example.assignment_group;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    EditText txtEmail, txtPassword;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        txtEmail = findViewById(R.id.txt_email);
        txtPassword = findViewById(R.id.txt_password);

    }

    public void login(View view) {
        String email, password;
        email = txtEmail.getText().toString();
        password = txtPassword.getText().toString();
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(Login.this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
        } else if (email.equals("admin") && password.equals("admin")) {
            Toast.makeText(Login.this, "Welcome Admin", Toast.LENGTH_SHORT).show();
        }
        else{
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    FirebaseUser currentUser = mAuth.getCurrentUser();
                    if (currentUser != null) {
                        String uid = currentUser.getUid();
                        myRef.child(uid).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                String role = snapshot.child("userType").getValue(String.class);
                                if (role != null) {
                                    switch (role){
                                        case "Admin":
                                            loginAsAdmin();
                                            break;
                                        case "Restaurant":
                                            loginAsRestaurant();
                                            break;
                                        case "Customer":
                                            loginAsCustomer();
                                            break;
                                            default:
                                            Toast.makeText(Login.this, "Invalid User Type", Toast.LENGTH_SHORT).show();
                                    }
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }

                    }
            });

        }

    }

    public void register(View view) {
        Intent intent = new Intent(this, RegisterAs.class);
        startActivity(intent);
    }

    public void loginAsAdmin() {
        Intent intent = new Intent(this, AdminDashboard.class);
        startActivity(intent);

    }
    public void loginAsRestaurant() {
        Intent intent = new Intent(this, RestaurantDashboard.class);
        startActivity(intent);

    }
    public void loginAsCustomer() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}

