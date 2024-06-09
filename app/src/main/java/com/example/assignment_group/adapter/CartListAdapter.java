package com.example.assignment_group.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.example.assignment_group.callbacks.OnItemClick;
import com.example.assignment_group.callbacks.QtyUpdates;
import com.example.assignment_group.databinding.CartViewBinding;
import com.example.assignment_group.models.CartModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {

    ArrayList<CartModel> cartModel;
    Context context;
    QtyUpdates qtyUpdates;
    OnItemClick onItemClick;

    public CartListAdapter(ArrayList<CartModel> cartModel, Context context, QtyUpdates qtyUpdates, OnItemClick itemClick) {
        this.cartModel = cartModel;
        this.context = context;
        this.qtyUpdates = qtyUpdates;
        this.onItemClick = itemClick;
    }

    @NonNull
    @Override
    public CartListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(CartViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CartListAdapter.ViewHolder holder, int position) {
        CartModel cartItem = cartModel.get(position);

        holder.binding.tvProductName.setText(cartItem.getItem().getItemName());
        holder.binding.textAmount.setText(String.format("$%.2f", cartItem.getPrice()));
        holder.binding.textQuantity.setText(String.valueOf(cartItem.getQty())); // Set the quantity
        double totalForItem = cartItem.getPrice() * cartItem.getQty(); // Calculate total amount
        holder.binding.tvTotalAmount.setText(String.format("$%.2f", totalForItem));
        // Load the image using Glide
        Glide.with(context)
                .load(cartItem.getItem().getItemImg()) // Ensure this method returns the correct image URL
                .into(holder.binding.productImg);


        // Set total amount

        // Set onClickListeners for the buttons to increase and decrease quantity
        holder.binding.buttonIncrease.setOnClickListener(v -> {
            int currentQuantity = cartItem.getQty();
            currentQuantity += 1;
            cartItem.setQty(currentQuantity);

            // Calculate total amount for the item
            double totalForItemUpdated = cartItem.getPrice() * currentQuantity;

            holder.binding.textQuantity.setText(String.valueOf(cartItem.getQty()));
            holder.binding.tvTotalAmount.setText(String.format("$%.2f", totalForItemUpdated));

            // Assuming qtyUpdates is an interface or callback for updating the quantity
            qtyUpdates.onUpdate(currentQuantity, position);
        });

        holder.binding.buttonDecrease.setOnClickListener(v -> {
            int currentQuantity = cartItem.getQty();
            if (currentQuantity > 1) {
                currentQuantity -= 1;
                cartItem.setQty(currentQuantity);
                double totalForItemUpdated = cartItem.getPrice() * currentQuantity;

                holder.binding.textQuantity.setText(String.valueOf(cartItem.getQty()));
                holder.binding.tvTotalAmount.setText(String.format("$%.2f", totalForItemUpdated));
                // Update the total amount logic if needed
                qtyUpdates.onUpdate(currentQuantity, position);
            }
        });

        holder.binding.buttonDelete.setOnClickListener(v -> {
            onItemClick.onClick(position,cartItem);
        });
    }




    private void removeFromSharedPreferences(String id) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        Set<String> savedIds = sharedPreferences.getStringSet("saved_ids", new HashSet<>());
        if (savedIds.contains(id)) {
            savedIds.remove(id);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putStringSet("saved_ids", savedIds);
            editor.apply();
        }
    }

    @Override
    public int getItemCount() {
        return cartModel.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CartViewBinding binding;

        public ViewHolder(@NonNull CartViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
