package com.flobamora.flobamora.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.flobamora.flobamora.Tools.DataBaseHelper;
import com.flobamora.flobamora.DetailActivity;
import com.flobamora.flobamora.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    public static String Place_Name = "";
    public static String Place_Image = "";
    public static String Place_Desc = "";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mDescs = new ArrayList<>();
    private ArrayList<String> mRatings = new ArrayList<>();
    private Context mContext;
    DataBaseHelper myDb;
    public RecyclerViewAdapter(Context context, ArrayList<String> names, ArrayList<String> imageUrls,
                                ArrayList<String> descs,ArrayList<String> ratings) {
        mNames = names;
        mImageUrls = imageUrls;
        mDescs = descs;
        mRatings = ratings;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called.");
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext).asBitmap().load(mImageUrls.get(position))
                .into(holder.imageView);
        holder.desc.setText(mDescs.get(position));
        holder.textView.setText(mNames.get(position));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("detail_place_name",mNames.get(position));
                bundle.putString("detail_place_image",mImageUrls.get(position));
                bundle.putString("detail_place_desc",mDescs.get(position));
                Intent intent   = new Intent(mContext, DetailActivity.class);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on an image: "+ mNames.get(position));
//                Toast.makeText(mContext, mNames.get(position), Toast.LENGTH_SHORT).show();
                Place_Name = mNames.get(position);
                Place_Image = mImageUrls.get(position);
                Place_Desc = mDescs.get(position);
                myDb = new DataBaseHelper(mContext);
                Boolean result = myDb.insertData(Place_Name,Place_Image, Place_Desc);
                if (result == true){
                    Toast.makeText(mContext,  mNames.get(position)+" inserted to list ", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(mContext, "Data insertion failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView, desc;
        Button add;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view_list_home);
            textView = itemView.findViewById(R.id.text_view_list_home);
            add = itemView.findViewById(R.id.addToList);
            desc= itemView.findViewById(R.id.desc);
        }
    }
}
