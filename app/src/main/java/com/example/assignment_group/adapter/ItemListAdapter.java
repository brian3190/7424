package com.example.assignment_group.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.transition.Transition;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.example.assignment_group.databinding.CardItemsDetalisBinding;
import com.example.assignment_group.models.CartModel;
import com.example.assignment_group.models.ItemModelClass;
import com.example.assignment_group.utils.SharedHelperClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {

ArrayList<ItemModelClass> itemList;
Context context;
    ArrayList<ItemModelClass> carddetais = new ArrayList<>();

public ItemListAdapter(ArrayList<ItemModelClass> itemList, Context context) {
    this.itemList = itemList;
    this.context = context;
}

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new ViewHolder(CardItemsDetalisBinding.inflate(LayoutInflater.from(parent.getContext()),
            parent, false));
}

@Override
public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    ItemModelClass user = itemList.get(position);

    holder.binding.tvTitle.setText(user.getItemName());
    holder.binding.tvDescription.setText(user.getItemDescription());
    holder.binding.tvTotalAmount.setText(user.getPrice().toString());
    Glide.with(context)
            .asBitmap()
            .load(itemList.get(position).getItemImg()) // Change this to your image URL
            .into(new CustomTarget<Bitmap>() {


                @Override
                public void onResourceReady(@NonNull Bitmap resource, @Nullable com.bumptech.glide.request.transition.Transition<? super Bitmap> transition) {
                    holder.binding.ivListImage.setImageBitmap(resource);
                }

                @Override
                public void onLoadCleared(@Nullable Drawable placeholder) {
                    // Handle cleanup
                }
            });

     holder.binding.btnAddCart.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
             String itemId = user.getId();
             Toast.makeText(context, "item ID "+itemId, Toast.LENGTH_SHORT).show();
            SharedHelperClass sharedHelperClass = new SharedHelperClass(context);
            List<CartModel> list  = sharedHelperClass.getCartList();
            addToCartIfNotExists(list, new CartModel(user.getId(), user, user.getPrice(), 1));

        }
     });





}

    public void addToCartIfNotExists(List<CartModel> cartItemList, CartModel newItem) {
        boolean found = false;
        for (CartModel item : cartItemList) {
            if (item.getId().equals(newItem.getId())) {
                found = true;
                break;
            }
        }
        if (!found) {
            cartItemList.add(newItem);
        }

        new SharedHelperClass(context).saveCartList(cartItemList);

    }


    @Override
public int getItemCount() {
    return itemList.size();
}

public class ViewHolder  extends RecyclerView.ViewHolder{

    CardItemsDetalisBinding binding;
    public ViewHolder(@NonNull CardItemsDetalisBinding itemView) {
        super(itemView.getRoot());
        binding = itemView;

    }
}




    }


