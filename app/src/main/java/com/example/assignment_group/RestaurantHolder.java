package com.example.assignment_group;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RestaurantHolder extends RecyclerView.ViewHolder {

    TextView name, category, address, phone;

    CardView cardView;

    public RestaurantHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.cv_name);
        category = itemView.findViewById(R.id.cv_category);
        address = itemView.findViewById(R.id.cv_address);
        phone = itemView.findViewById(R.id.cv_phone);
        cardView = itemView.findViewById(R.id.cv_restaurant);

    }

}
