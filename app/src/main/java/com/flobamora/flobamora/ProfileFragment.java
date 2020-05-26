package com.flobamora.flobamora;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.flobamora.flobamora.Adapter.RecyclerViewAdapter_profile;
import com.flobamora.flobamora.Tools.DataBaseHelper;

import java.util.ArrayList;

public class ProfileFragment extends Fragment{
    private static final String TAG = "ProfileFragment";
    public static RecyclerView recyclerView;
    DataBaseHelper myDb;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_profile, container, false);
        //Retrieve Data from SQLITE
        final ArrayList<String> ID_Profile = new ArrayList<>();
        final ArrayList<String> mNames_Profile = new ArrayList<>();
        final ArrayList<String> mImageUrls_Profile = new ArrayList<>();
        final ArrayList<String> mDescs_Profile = new ArrayList<>();
          myDb = new DataBaseHelper(getActivity());
               Cursor res = myDb.getAllData();
                if (res!=null && res.getCount()>0){
                    while (res.moveToNext()){
                    mNames_Profile.add(res.getString(1));
                    mImageUrls_Profile.add(res.getString(2));
                    ID_Profile.add(res.getString(0));
                    mDescs_Profile.add(res.getString(3));
                    }
                    /*final RecyclerView */recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_profile_fragment);
                    final RecyclerViewAdapter_profile adapter = new RecyclerViewAdapter_profile(getContext(), mNames_Profile, mImageUrls_Profile, ID_Profile, mDescs_Profile);
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
                    recyclerView.setLayoutManager(gridLayoutManager);
                    recyclerView.setAdapter(adapter);

                    new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                            ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                        @Override
                        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                            return false;
                        }

                        @Override
                        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                            myDb.deleteData(RecyclerViewAdapter_profile.ID);
                            Toast.makeText(getActivity(),
                                    RecyclerViewAdapter_profile.PLACE_NAME+" Delete", Toast.LENGTH_SHORT).show();
                        }
                    }).attachToRecyclerView(recyclerView);
                }else {
                    Toast.makeText(getActivity(),"No Data retrieve", Toast.LENGTH_SHORT).show();
                }
        ImageView imageView = (ImageView) view.findViewById(R.id.nav_setting);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(), SettingActivity.class);
                        startActivity(intent);
                    }
                });
        return view;
    }

}
