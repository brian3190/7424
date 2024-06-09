package com.example.assignment_group;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterCustomer extends AppCompatActivity {

    EditText etFirstName, etLastName, etUserName, etPassword, etPhoneNumber, etEmail, etAddress, etBankAccount;

    FirebaseDatabase database = FirebaseDatabase.getInstance();


    FirebaseAuth auth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_customer);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etAddress = findViewById(R.id.etAddress);
        etBankAccount = findViewById(R.id.etBankAccount);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etUserName = findViewById(R.id.etUserName);
    }

    public void registerCustomer(View view) {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String phoneNumber = etPhoneNumber.getText().toString();
        String address = etAddress.getText().toString();
        String bankAccount = etBankAccount.getText().toString();
        String firstname = etFirstName.getText().toString();
        String lastname = etLastName.getText().toString();
        String username = etUserName.getText().toString();
        Customer customer = new Customer(firstname, lastname, username, email, password, phoneNumber, address, bankAccount);
        if (email.isEmpty() || password.isEmpty() || phoneNumber.isEmpty() || address.isEmpty() || bankAccount.isEmpty() || firstname.isEmpty() || lastname.isEmpty() || username.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();

        }
        else {

            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        FirebaseUser currentUser = auth.getCurrentUser();
                        if (currentUser != null) {
                            DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("customers");
//                            Customer customer = new Customer(firstname, lastname, username, email, password, phoneNumber, address, bankAccount);
                            myRef.push().setValue(customer);
                            Intent intent = new Intent(RegisterCustomer.this, MainActivity.class);
                            intent.putExtra("currentUser", currentUser);
                            startActivity(intent);

                            Toast.makeText(RegisterCustomer.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(RegisterCustomer.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            });


        }


    }

}