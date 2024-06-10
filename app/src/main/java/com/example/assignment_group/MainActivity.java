package com.example.assignment_group;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
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

public class MainActivity extends AppCompatActivity {
    SearchView searchView;
    FirebaseDatabase database;
    DatabaseReference myRef;

    FirebaseAuth mAuth;
    TextView welcome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome = findViewById(R.id.txt_welcome);

        searchView = findViewById(R.id.search_view);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("restaurants");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    public void browse(View view) {
        Intent intent = new Intent(this, RestaurantRecyclerView.class);
        startActivity(intent);
    }

    public void cart(View view) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {


            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Please log in to view cart", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        }
    }

    public void openProfile(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
    public void customiseUser(View view) {

    }

    public void addFunds(View view) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            Intent intent = new Intent(this, AddFunds.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Please log in to add funds", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        }

    }
}