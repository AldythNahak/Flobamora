package com.flobamora.flobamora.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.flobamora.flobamora.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    public TextView dataName;
    public ImageView dataSrc;
    public TextView dataRating;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);

        dataName = itemView.findViewById(R.id.data_name);
        dataSrc = itemView.findViewById(R.id.data_image);
        dataRating = itemView.findViewById(R.id.data_rating);
    }
}
