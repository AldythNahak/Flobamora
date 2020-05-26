package com.flobamora.flobamora;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.flobamora.flobamora.Adapter.RecyclerViewAdapter;
import com.flobamora.flobamora.Adapter.RecyclerViewAdapter2;
import com.flobamora.flobamora.Retrofit.APIList;
import com.flobamora.flobamora.Retrofit.Flobamora;
import com.flobamora.flobamora.Retrofit.RetrofitClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mDescs = new ArrayList<>();
    private ArrayList<String> mRatings = new ArrayList<>();
    private ArrayList<String> mNames1 = new ArrayList<>();
    private ArrayList<String> mImageUrls1 = new ArrayList<>();
    private ArrayList<String> mDescs1 = new ArrayList<>();
    private ArrayList<String> mRatings1 = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager manager;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImageUrls.add("https://media-cdn.tripadvisor.com/media/photo-w/0f/5d/cd/3b/nihiwatu-resort-sumba.jpg");
        mNames.add("Nihiwatu Beach");
        mDescs.add("Nihiwatu Beach. The location is near to Waikabukak City and it is considered one of the best beaches in the world! In fact, it is chosen as the number one beach in Asia as compared to others (especially in terms of beauty). Due to the richness of beauty of Nihiwatu Beach, tourists can do various fun activities on site. For instance, it is surfing! Thanks to the big waves. Tourists only need a good surfing board and some skills in order to enjoy such kind of sports.");
        mRatings.add("9/10");

        mImageUrls.add("https://media-cdn.tripadvisor.com/media/photo-m/1280/1a/13/07/c1/descent-with-lorenzo.jpg");
        mNames.add("Mount Inerie Peak");
        mDescs.add("Mount Inerie is one of tourist attractions in Flores Island. The mountain is located in Bajawa district, Ngada regency of Flores Island. From Bajawa city we can see the mountain as a pyramid with perfectly straight which is an eye-catching peak in the Florinese ‘mountain skyline’. With an altitude of 2,245 meters above sea level, Mount Inerie is also one of the highest volcanoes in Flores. If you would like to climb to the top, you can start your trip at night or in the very early morning. You will be rewarded with a magical moment when the sun slowly rises up behind the hills.");
        mRatings.add("10/10");

        mImageUrls.add("https://media-cdn.tripadvisor.com/media/photo-m/1280/1b/3a/ae/07/kanawa-island.jpg");
        mNames.add("Kanawa Island");
        mDescs.add("The island of Kanawa, only some 15 km from the growing fishermen’s town of Labuan Bajo on Flores, is fringed with a bed of coral reefs teeming with colorful fish all around. Its turquoise water is exceptionally calm and clear. Swimming and snorkeling are most poular family activities here. Dive down the sea from the jetty, and meet schools of fish that cloud the stilts. Hours would pass so quietly as you are busy with all of these beach activities.");
        mRatings.add("8/10");
        ////////////
        mImageUrls1.add("https://media-cdn.tripadvisor.com/media/photo-o/10/7c/72/32/pantai-tablolong.jpg");
        mNames1.add("Tablolong Beach");
        mDescs1.add("Tablolong Beach has white sand beach, panoramic rock also so beautiful. Corals at the site has been covered with cement to provide comfort for the visitors who will sit on it. After enjoying the panoramic view of the beach. Now is the time along the coastal section by section to see the coral reefs. That said, the reef Tablolong Beach still intact, untouched fish bombs. Not surprisingly, these beach had been hold event of international fishing competition.");
        mRatings1.add("8/10");

        mImageUrls1.add("https://media-cdn.tripadvisor.com/media/photo-m/1280/1a/9b/42/5b/nella-foto-sono-immortalati.jpg");
        mNames1.add("Kelimutu Lake");
        mDescs1.add("Kelimutu lakes are unpredictable as to when and what color they will change into. Sometimes, the colors are blue, green, and black, and some other times they turn to white, red, and blue. The last time a traveler saw them, one was dark brown, just like a pond of chocolate. Previously, the east lake was red and the middle lake was blue. Lake Kelimutu is part of the Kelimutu National Park, presenting a highly aesthetic value and surreal experience. The national park’s highest point is 5,679 feet at Mt Kelibara (1,731 meters), and 5,544 feet high (1,690 meters) at Mt Kelimutu. It is a national park that protects 19 endemic and endangered animals, among which, the Floresian punai (Treron floris), Wallacea owl (Otus silvicola), Floresian kancilan (Pachycephala nudigula), Floresian eagle (Spizeatus floris), and Timorese tesia (Tesia everetti).");
        mRatings1.add("9/10");

        mImageUrls1.add("https://media-cdn.tripadvisor.com/media/photo-o/16/66/9f/2e/padar-island-is-hottest.jpg");
        mNames1.add("Padar Island");
        mDescs1.add("Padar Island is a remote and wild island located in the middle of the straight between Rinca Island and Komodo Island. Defended by strong currents and swell coming from the nearby Indian ocean, going to Padar Island is an adventure in itself. Hello Flores team like to call it “Neverland” and will understand why once you will be there! Steep and dry hills, cliffs falling straight into the ocean, sea eagles flying around, gigantic bays with crystal waters and many unknown pink-sand beaches are what give this place a truly unique atmosphere. A one-hour trek to the top of Padar Kecil will bring you to a breathtaking panorama overlooking Komodo National Park. Sunrise and sunset times are the best times of the day to do the trekking with endless changing color in the sky.");
        mRatings1.add("10/10");

        mImageUrls1.add("https://media-cdn.tripadvisor.com/media/photo-o/03/9b/43/72/rinca-island.jpg");
        mNames1.add("Rinca Island");
        mDescs1.add("Rinca is a rough and tumble little island located in East Nusa Tenggara, Indonesia just off the western tip of Flores. One of only a very few places to spot Komodo dragons in the wild, Rinca is often overlooked by tourists on their way to the more-popular Komodo Island. You are much more likely to spot Komodo dragons in their natural habitat on Rinca Island where there is less impact from tourism.");
        mRatings1.add("8/10");

        mImageUrls.add("https://media-cdn.tripadvisor.com/media/photo-m/1280/1b/35/b9/e7/pink-beach.jpg");
        mNames.add("Pink Beach");
        mDescs.add("The corals of the Pink Beach’s underwater gardens are in excellent condition, with hundreds of species of both soft and hard corals, and thousands of species of fish. Pink Beach is a terrific choice for snorkelers and beginner divers as even the shallow waters are home to an abundance of species to keep you more than entertained.");
        mRatings.add("9/10");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView_new = view.findViewById(R.id.recycler_view_home_fragment);
        RecyclerViewAdapter adapter_new = new RecyclerViewAdapter(getContext(), mNames, mImageUrls,mDescs,mRatings);
        LinearLayoutManager linearLayoutManager_new = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView_new.setLayoutManager(linearLayoutManager_new);
        recyclerView_new.setAdapter(adapter_new);

        RecyclerView recyclerView_most = view.findViewById(R.id.recycler_view_home_fragment1);
        RecyclerViewAdapter2 adapter_most = new RecyclerViewAdapter2(getContext(), mNames1, mImageUrls1,mDescs1,mRatings1);
        LinearLayoutManager linearLayoutManager_most = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView_most.setLayoutManager(linearLayoutManager_most);
        recyclerView_most.setAdapter(adapter_most);

        return view;
    }
}
