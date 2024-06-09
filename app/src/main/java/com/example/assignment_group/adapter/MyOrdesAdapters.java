package com.example.assignment_group.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_group.databinding.MyOrderListBinding;
import com.example.assignment_group.models.MyOrdersmodel;
import com.example.assignment_group.shoppingcart.ComfirmOrderModel; // Ensure this import is correct
import com.example.assignment_group.shoppingcart.OrderIdComfirmationPage;
import com.example.assignment_group.shoppingcart.YourOrderpage;

import java.util.ArrayList;

public class MyOrdesAdapters extends RecyclerView.Adapter<MyOrdesAdapters.ViewHolder> {

    ArrayList<ComfirmOrderModel> myOrdersmodels;
    Context context;



    public MyOrdesAdapters(ArrayList<ComfirmOrderModel> myOrdersmodels, Context context) {

        this.myOrdersmodels = myOrdersmodels;
        this.context = context;

    }

    @NonNull
    @Override
    public MyOrdesAdapters.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MyOrderListBinding binding = MyOrderListBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrdesAdapters.ViewHolder holder, int position) {
        ComfirmOrderModel model = myOrdersmodels.get(position);

     //   holder.binding.orderId.setText(model.getOrderid());
        holder.binding.totalAmount.setText(String.valueOf(model.getTotalAmountl()));




        holder.binding.myordersCardview.setOnClickListener(v -> {
            Intent intent = new Intent(context, OrderIdComfirmationPage.class);
            intent.putExtra("order", model.toJsonString());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return myOrdersmodels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final MyOrderListBinding binding;

        public ViewHolder(@NonNull MyOrderListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
