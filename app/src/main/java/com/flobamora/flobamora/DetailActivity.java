package com.flobamora.flobamora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private RelativeLayout rlayout;
    private Animation animation;
    private TextView place_name, place_desc;
    private ImageView place_image;
    private Button btn_maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                Toast.makeText(this, "Membutuhkan Izin Lokasi", Toast.LENGTH_SHORT).show();
            } else {

                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                        1);
            }
        } else {
            // Permission has already been granted
            Toast.makeText(this, "Izin Lokasi diberikan", Toast.LENGTH_SHORT).show();
        }




        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.bgHeader);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rlayout = findViewById(R.id.rlayout);
        animation = AnimationUtils.loadAnimation(this,R.anim.uptodowndiagonal);
        rlayout.setAnimation(animation);

        place_name = findViewById(R.id.Detail_Place_Name);
        place_image = findViewById(R.id.Detail_Place_Image);
        place_desc = findViewById(R.id.Detail_Place_Desc);
//        btn_maps = findViewById(R.id.btn_gmaps);

        Bundle bundle = getIntent().getExtras();
        place_name.setText(bundle.getString("detail_place_name"));
        Glide.with(this).asBitmap().load(bundle.getString("detail_place_image"))
                .into(place_image);
        place_desc.setText(bundle.getString("detail_place_desc"));
//        btn_maps.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getBaseContext(), PlaceAutoCompleteActivity.class);
//                startActivity(intent);
//            }
//        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openAutoPlace(View view) {
        startActivity(new Intent(this, PlaceAutoCompleteActivity.class));
    }

    public void openDirectionMap(View view) {
        startActivity(new Intent(this, DirectionActivity.class));
    }

    public void openOjek(View view) {
        startActivity(new Intent(this, OjekActivity.class));
    }
}
