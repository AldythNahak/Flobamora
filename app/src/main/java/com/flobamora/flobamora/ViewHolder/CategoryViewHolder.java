package com.flobamora.flobamora.ViewHolder;

import android.view.View;
import android.widget.TextView;

import com.flobamora.flobamora.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    public TextView categoryName;
    public RecyclerView rvHome;
    public RecyclerView.LayoutManager manager;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);

        manager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        categoryName = itemView.findViewById(R.id.category_name);
        rvHome = itemView.findViewById(R.id.rv_item);
        rvHome.setLayoutManager(manager);
    }
}
