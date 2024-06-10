package com.example.assignment_group.callbacks;

import com.example.assignment_group.contollers.CartViewModel;
import com.example.assignment_group.models.CartModel;
import com.example.assignment_group.models.ItemModelClass;

public interface OnItemClick {

    public void onClick(int pod, CartModel item);
}
