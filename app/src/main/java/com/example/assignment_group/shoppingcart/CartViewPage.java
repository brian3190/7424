package com.example.assignment_group.shoppingcart;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.assignment_group.R;
import com.example.assignment_group.adapter.CartListAdapter;
import com.example.assignment_group.callbacks.OnItemClick;
import com.example.assignment_group.callbacks.QtyUpdates;
import com.example.assignment_group.databinding.ActivityCartViewPageBinding;
import com.example.assignment_group.models.CartModel;
import com.example.assignment_group.models.ItemModelClass;
import com.example.assignment_group.utils.SharedHelperClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CartViewPage extends AppCompatActivity {

    private ActivityCartViewPageBinding binding;
    ArrayList<CartModel> cartmodel = new ArrayList<>();
    ArrayList<CartModel> filteredList = new ArrayList<>();
    CartListAdapter adapter;

    String img1 = "https://media.istockphoto.com/id/1221237754/photo/two-halves-of-club-sandwich-on-white.jpg?s=612x612&w=0&k=20&c=jTThChWPJoFPxOdW1F4I-UzDqzS97iIgTm4-JJe-gOQ=";
    String img2 = "https://media.istockphoto.com/id/1156895944/photo/cheese-masala-dosa-recipe-with-sambar-and-chutney-selective-focus.jpg?s=612x612&w=0&k=20&c=KYAt25Be5Ww9BdHrD5UFfRhDTBJFXBBC9OhN6G5r-6I=";

    String img3 = "https://media.istockphoto.com/id/831817536/photo/maggie-masala-noodles.jpg?s=612x612&w=0&k=20&c=DyyikWEWivdkxs9P_A5zvXvKcZsfpGcc5JB4aMHU6pM=";
    String img4 = "https://media.istockphoto.com/id/1302436326/photo/junk-food-homemade-beef-burgers-on-vintage-wooden-background.jpg?s=612x612&w=0&k=20&c=NsyDE31unoNd80wGfrkMOqvsnjeNOpHER-yL_8KwcRw=";

    String TAG = "CartViewPage";

    SharedHelperClass sharedHelperClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityCartViewPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedHelperClass = new SharedHelperClass(this);
        cartmodel = (ArrayList<CartModel>) sharedHelperClass.getCartList();
        Log.e(TAG, "onCreate: list" + cartmodel.toString() );
        if (!cartmodel.isEmpty()){
            initRv();

        }

        binding.layoutCheckItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double totalAmount = calculateTotalAmount();
                Intent intent = new Intent(CartViewPage.this, ComfirmOrder.class);
                addProductDetailsToIntent(intent);
                intent.putExtra("totalAmount", totalAmount);
                startActivity(intent);
            }
        });
        binding.imgBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void initRv() {

        adapter = new CartListAdapter(cartmodel, this, new QtyUpdates() {
            @Override
            public void onUpdate(int qty, int index) {
                cartmodel.get(index).setQty(qty);
                updateTotalAmount();
            }
        }, new OnItemClick() {
            @Override
            public void onClick(int pod, CartModel item) {
                cartmodel.remove(pod);
                sharedHelperClass.saveCartList(cartmodel);
                initRv();
            }
        });
        binding.cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.cartRecyclerView.setAdapter(adapter);
        updateTotalAmount();

    }

    private void updateTotalAmount() {
        double totalAmount = calculateTotalAmount();
        TextView totalAmountTextView = findViewById(R.id.totalAmountTextView);
        totalAmountTextView.setText(String.format("$%.2f", totalAmount));
    }

    private double calculateTotalAmount() {
        double totalAmount = 0.0;
        for (CartModel item : cartmodel) {
            Log.e(TAG, "updateTotalAmount: " + item.getQty());
            totalAmount += item.getQty() * item.getPrice();
        }
        return totalAmount;
    }

    private void addProductDetailsToIntent(Intent intent) {
        ArrayList<String> productNames = new ArrayList<>();
        ArrayList<Double> productPrices = new ArrayList<>();
        ArrayList<Integer> productQuantities = new ArrayList<>();
        ArrayList<Double> productTotals = new ArrayList<>();

        for (CartModel item : cartmodel) {
            productNames.add(item.getItem().getItemName());
            productPrices.add(item.getPrice());
            productQuantities.add(item.getQty());
            productTotals.add(item.getQty() * item.getPrice());
        }

        intent.putStringArrayListExtra("product_names", productNames);
        intent.putExtra("product_prices", productPrices);
        intent.putExtra("product_quantities", productQuantities);
        intent.putExtra("product_totals", productTotals);
    }

}
