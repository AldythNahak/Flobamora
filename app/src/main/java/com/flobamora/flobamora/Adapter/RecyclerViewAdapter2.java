package com.flobamora.flobamora.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.flobamora.flobamora.Tools.DataBaseHelper;
import com.flobamora.flobamora.DetailActivity;
import com.flobamora.flobamora.R;

import java.util.ArrayList;

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter2";
    public static String Place_Name = "";
    public static String Place_Image = "";
    public static String Place_Desc = "";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mDescs = new ArrayList<>();
    private ArrayList<String> mRatings = new ArrayList<>();
    private Context mContext;
    DataBaseHelper myDb;

    public RecyclerViewAdapter2(Context context, ArrayList<String> names, ArrayList<String> imageUrls,
                                ArrayList<String> descs,ArrayList<String> ratings) {
        mNames = names;
        mImageUrls = imageUrls;
        mDescs = descs;
        mRatings = ratings;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent2, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called.");
//        View view = LayoutInflater.from(parent2.getContext()).inflate(R.layout.item,parent2,false);
        View view = LayoutInflater.from(parent2.getContext()).inflate(R.layout.item_view, parent2, false);
        return new RecyclerViewAdapter2.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewAdapter2.ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext).asBitmap().load(mImageUrls.get(position))
                .into(holder.imageView);
        holder.tv2.setText(mRatings.get(position));
        holder.textView.setText(mNames.get(position));
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
                    Toast.makeText(mContext, mNames.get(position)+" inserted to list ", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(mContext, "Data insertion failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
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
    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView, tv2;
        Button add;

        public ViewHolder(View itemView2) {
            super(itemView2);
            imageView = itemView2.findViewById(R.id.item_image);
            textView = itemView2.findViewById(R.id.item_name);
            tv2 = itemView2.findViewById(R.id.item_rating);
            add = itemView2.findViewById(R.id.addToList);
        }
    }
}