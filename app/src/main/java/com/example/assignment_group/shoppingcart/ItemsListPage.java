package com.example.assignment_group.shoppingcart;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.assignment_group.adapter.ItemListAdapter;
import com.example.assignment_group.callbacks.OnSuccessListner;
import com.example.assignment_group.databinding.ActivityItemsListPage2Binding;
import com.example.assignment_group.models.ItemModelClass;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class ItemsListPage extends AppCompatActivity {



    ArrayList<ItemModelClass> itemList = new ArrayList<>();
    private ActivityItemsListPage2Binding binding;
    String dbItemRef = "item";

    String TAG = "ItemsListPage";


    FirebaseFirestore  db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityItemsListPage2Binding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        db = FirebaseFirestore.getInstance();

        getTournamentFromDb(new OnSuccessListner() {
            @Override
            public void onSuccess() {
                initItemList();
            }
        });





        binding.addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ItemsListPage.this, CartViewPage.class);
                startActivity(intent);

            }
        });

        binding.btnYourOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ItemsListPage.this, YourOrderpage.class);
                startActivity(intent);
            }
        });

    }

    void initItemList(){

      /*  itemList.add(new ItemModelClass("1","Sandwich","testy and yummy sandwitch for you", 30.0,"https://images.unsplash.com/photo-1546069901-ba9599a7e63c?q=80&w=1760&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"));
        itemList.add(new ItemModelClass("2","Dhosa","testy and yummy dhosa for you",40.0,"img"));
        itemList.add(new ItemModelClass("3","Soup","testy and yummy Soup for you",80.0,"img"));
        itemList.add(new ItemModelClass("4","Maggie","testy and yummy Maggie for you",10.0,"img"));
        itemList.add(new ItemModelClass("5","Burger","testy and yummy Burger for you",20.0,"img"));

*/
        ItemListAdapter adapter = new ItemListAdapter(itemList,this);
        binding.cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.cartRecyclerView.setAdapter(adapter);
    }

    public  void createItem(ItemModelClass quiz){
        try{

            db.collection(dbItemRef).document(quiz.getId()).set(quiz).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {

                            Log.e(TAG, "DocumentSnapshot successfully written!");

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.e(TAG, "onFailure: " + e.getMessage() );

                        }
                    });
        }catch (Exception e){
            Log.e(TAG, "createQuiz: error : " +e.getMessage(),e );

        }

    }

    //view all items
    public void getTournamentFromDb(OnSuccessListner successListner) {

        CollectionReference  itemsRef = db.collection(dbItemRef);

        // Order by start date (ascending)
        itemsRef
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        itemList.clear();
                        for (DocumentSnapshot document : task.getResult()) {
                            ItemModelClass tournament = document.toObject(ItemModelClass.class);
                            if (tournament != null) {
                                itemList.add(tournament);
                            }
                        }
                        successListner.onSuccess();
                        // Update recycler view
                    } else {
                        Log.e(TAG, "Error getting documents.", task.getException());
                        successListner.onSuccess();

                    }
                });
    }

}