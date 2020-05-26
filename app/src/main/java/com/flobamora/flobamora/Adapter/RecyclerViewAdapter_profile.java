package com.flobamora.flobamora.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.flobamora.flobamora.Tools.DataBaseHelper;
import com.flobamora.flobamora.DetailActivity;
import com.flobamora.flobamora.R;

import java.util.ArrayList;

public class RecyclerViewAdapter_profile extends RecyclerView.Adapter<RecyclerViewAdapter_profile.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter_profile";
    public static String ID = "";
    public static String PLACE_NAME = "";


    private ArrayList<String> ID_Profile = new ArrayList<>();
    private ArrayList<String> mNames_Profile = new ArrayList<>();
    private ArrayList<String> mImageUrls_Profile = new ArrayList<>();
    private ArrayList<String> mDescs_Profile = new ArrayList<>();
    private Context mContext_Profile;
    DataBaseHelper myDb;
    public RecyclerViewAdapter_profile(Context context, ArrayList<String> names, ArrayList<String> imageUrls,ArrayList<String> id,
                                       ArrayList<String> descs) {
        mNames_Profile = names;
        mImageUrls_Profile = imageUrls;
        mDescs_Profile = descs;
        mContext_Profile = context;
        ID_Profile = id;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called.");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_profile, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext_Profile).asBitmap().load(mImageUrls_Profile.get(position))
                .into(holder.imageView);

        holder.textView.setText(mNames_Profile.get(position));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("detail_place_name",mNames_Profile.get(position));
                bundle.putString("detail_place_image",mImageUrls_Profile.get(position));
                bundle.putString("detail_place_desc",mDescs_Profile.get(position));
                Intent intent   = new Intent(mContext_Profile, DetailActivity.class);
                intent.putExtras(bundle);
                mContext_Profile.startActivity(intent);
            }
        });
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ID = ID_Profile.get(position);
                PLACE_NAME = mNames_Profile.get(position);
                Toast.makeText(mContext_Profile, "Swipe to Delete", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageUrls_Profile.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.Profile_Image_Destination);
            textView = itemView.findViewById(R.id.Profile_Place_Destination);
            cardView = itemView.findViewById(R.id.Profile_card);
        }
    }
}
