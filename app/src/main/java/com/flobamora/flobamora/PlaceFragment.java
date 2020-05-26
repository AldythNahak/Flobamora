package com.flobamora.flobamora;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.flobamora.flobamora.Adapter.RecyclerViewAdapter2;
import com.flobamora.flobamora.Model.Category;
import com.flobamora.flobamora.Model.Data;
import com.flobamora.flobamora.ViewHolder.CategoryViewHolder;
import com.flobamora.flobamora.ViewHolder.ItemViewHolder;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlaceFragment extends Fragment {
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mDescs = new ArrayList<>();
    private ArrayList<String> mRatings = new ArrayList<>();
    private ArrayList<String> mNames1 = new ArrayList<>();
    private ArrayList<String> mImageUrls1 = new ArrayList<>();
    private ArrayList<String> mDescs1 = new ArrayList<>();
    private ArrayList<String> mRatings1= new ArrayList<>();
    private ArrayList<String> mNames2 = new ArrayList<>();
    private ArrayList<String> mImageUrls2 = new ArrayList<>();
    private ArrayList<String> mDescs2 = new ArrayList<>();
    private ArrayList<String> mRatings2 = new ArrayList<>();
    private ArrayList<String> mNames3 = new ArrayList<>();
    private ArrayList<String> mImageUrls3 = new ArrayList<>();
    private ArrayList<String> mDescs3 = new ArrayList<>();
    private ArrayList<String> mRatings3 = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImageUrls.add("https://media-cdn.tripadvisor.com/media/photo-o/10/23/2b/fa/photo0jpg.jpg");
        mNames.add("Nemberala Beach");
        mDescs.add("Nembrala Beach is situated in a small island named Rote Island in East Nusa Tenggara. Precisely, the beach lies just the Southwest of Timor. This is at the tip of the southern part region of Indonesia. The total area of this island is only about 1,214 km2. With such small size, the island has many things to offer to visitors, including subtropical topography, unique culture and tropical waters.");
        mRatings.add("9/10");

        mImageUrls.add("https://media-cdn.tripadvisor.com/media/photo-w/0f/5d/cd/3b/nihiwatu-resort-sumba.jpg");
        mNames.add("Nihiwatu Beach");
        mDescs.add("Nihiwatu Beach. The location is near to Waikabukak City and it is considered one of the best beaches in the world! In fact, it is chosen as the number one beach in Asia as compared to others (especially in terms of beauty). Due to the richness of beauty of Nihiwatu Beach, tourists can do various fun activities on site. For instance, it is surfing! Thanks to the big waves. Tourists only need a good surfing board and some skills in order to enjoy such kind of sports.");
        mRatings.add("9/10");

        mImageUrls.add("https://media-cdn.tripadvisor.com/media/photo-o/10/7c/72/32/pantai-tablolong.jpg");
        mNames.add("Tablolong Beach");
        mDescs.add("Tablolong Beach has white sand beach, panoramic rock also so beautiful. Corals at the site has been covered with cement to provide comfort for the visitors who will sit on it. After enjoying the panoramic view of the beach. Now is the time along the coastal section by section to see the coral reefs. That said, the reef Tablolong Beach still intact, untouched fish bombs. Not surprisingly, these beach had been hold event of international fishing competition.");
        mRatings.add("8/10");

        mImageUrls.add("https://media-cdn.tripadvisor.com/media/photo-m/1280/1b/35/b9/e7/pink-beach.jpg");
        mNames.add("Pink Beach");
        mDescs.add("The corals of the Pink Beach’s underwater gardens are in excellent condition, with hundreds of species of both soft and hard corals, and thousands of species of fish. Pink Beach is a terrific choice for snorkelers and beginner divers as even the shallow waters are home to an abundance of species to keep you more than entertained.");
        mRatings.add("9/10");

        mImageUrls.add("https://media-cdn.tripadvisor.com/media/photo-m/1280/13/d6/6f/c1/beach.jpg");
        mNames.add("Walakiri Beach");
        mDescs.add("Being one of the most beautiful beaches in East Sumba Regency, Walakiri is indeed worth a visit when you are in Indonesia. The waves are calm and the shoreline features stunning white sand. Plus, it has a sloping characteristic which is suitable for water sports. Perhaps the most distinct characteristic is the presence of mangroves that grow on the shore. These plants make the beach more beautiful and unique, which is perfect for photography. Moreover, the silhouette of those mangroves looks hypnotizing when the sunset appears!");
        mRatings.add("9/10");

        mImageUrls.add("https://media-cdn.tripadvisor.com/media/photo-m/1280/16/97/c1/3b/koka-beach-flores-indonesie.jpg");
        mNames.add("Koka Beach");
        mDescs.add("Koka beach is one of beaches in Sikka Regency, East Nusa Tenggara Province. Precisely in Wolowiro Village, Paga District, this beach is located on the south coast of Flores Island. From Maumere City, it takes around 48 km. If you start your journey from Jakarta, Surabaya, Makassar, and Denpasar, you take a flight to Maumere City. Koka beach is a beach which is very attractive with clean sea views, as well as the water is very clear, soft white sand stretches forming segment, left and right there are cliffs like a natural painting looks very artistic.");
        mRatings.add("9/10");
        /////////////////////////////
        mImageUrls1.add("https://media-cdn.tripadvisor.com/media/photo-m/1280/1a/9b/42/5b/nella-foto-sono-immortalati.jpg");
        mNames1.add("Kelimutu Lake");
        mDescs1.add("Kelimutu lakes are unpredictable as to when and what color they will change into. Sometimes, the colors are blue, green, and black, and some other times they turn to white, red, and blue. The last time a traveler saw them, one was dark brown, just like a pond of chocolate. Previously, the east lake was red and the middle lake was blue. Lake Kelimutu is part of the Kelimutu National Park, presenting a highly aesthetic value and surreal experience. The national park’s highest point is 5,679 feet at Mt Kelibara (1,731 meters), and 5,544 feet high (1,690 meters) at Mt Kelimutu. It is a national park that protects 19 endemic and endangered animals, among which, the Floresian punai (Treron floris), Wallacea owl (Otus silvicola), Floresian kancilan (Pachycephala nudigula), Floresian eagle (Spizeatus floris), and Timorese tesia (Tesia everetti).");
        mRatings1.add("9/10");

        mImageUrls1.add("https://media-cdn.tripadvisor.com/media/photo-m/1280/17/ae/1d/89/indahnya-danau-weekuri.jpg");
        mNames1.add("Weekuri Lake");
        mDescs1.add("Unlike regular lakes with their fresh water, Weekuri Lake features salty water! It is because the lake is actually a lagoon, which is getting the water from the nearby sea. The water enters the lake from rock crevices of coral reefs that surround the lake, actually. The next amazing feature of the lake is definitely its green bluish Tosca color! It looks unspoiled and crystal clear as well, in fact. What is more? The nuance feels comfy due to the presence of green plants and shady trees that surround the lake. Plus, the water features both warm and cold sensation, depending on the location where tourists may get in.");
        mRatings1.add("9/10");

        mImageUrls1.add("https://media-cdn.tripadvisor.com/media/photo-m/1280/1a/13/07/c1/descent-with-lorenzo.jpg");
        mNames1.add("Mount Inerie Peak");
        mDescs1.add("Mount Inerie is one of tourist attractions in Flores Island. The mountain is located in Bajawa district, Ngada regency of Flores Island. From Bajawa city we can see the mountain as a pyramid with perfectly straight which is an eye-catching peak in the Florinese ‘mountain skyline’. With an altitude of 2,245 meters above sea level, Mount Inerie is also one of the highest volcanoes in Flores. If you would like to climb to the top, you can start your trip at night or in the very early morning. You will be rewarded with a magical moment when the sun slowly rises up behind the hills.");
        mRatings1.add("10/10");

        mImageUrls1.add("https://media-cdn.tripadvisor.com/media/photo-o/16/66/9f/2e/padar-island-is-hottest.jpg");
        mNames1.add("Padar Island");
        mDescs1.add("Padar Island is a remote and wild island located in the middle of the straight between Rinca Island and Komodo Island. Defended by strong currents and swell coming from the nearby Indian ocean, going to Padar Island is an adventure in itself. Hello Flores team like to call it “Neverland” and will understand why once you will be there! Steep and dry hills, cliffs falling straight into the ocean, sea eagles flying around, gigantic bays with crystal waters and many unknown pink-sand beaches are what give this place a truly unique atmosphere. A one-hour trek to the top of Padar Kecil will bring you to a breathtaking panorama overlooking Komodo National Park. Sunrise and sunset times are the best times of the day to do the trekking with endless changing color in the sky.");
        mRatings1.add("10/10");

        mImageUrls1.add("https://media-cdn.tripadvisor.com/media/photo-m/1280/18/f0/a5/a4/3.jpg");
        mNames1.add("Batu Bolong Reef");
        mDescs1.add("One of the signature dive sites of the northern part of Komodo National Park, Batu Balong means the ‘rock with the hole in it’. Which indeed it is. Batu Bolong is also accessible in many different current situations, and is often the ‘check out’ dive site for newly arrived divers.");
        mRatings1.add("10/10");
        ////////////////////////////////
        mImageUrls2.add("https://media-cdn.tripadvisor.com/media/photo-m/1280/13/4d/16/01/good-view.jpg");
        mNames2.add("Cunca Wulang Waterfall");
        mDescs2.add("The Cunca Wulang is about 30 kilometers to the east of Labuan Bajo, which can be reached in about an hour drive. This location has a clear river valley water flow and is surrounded by artistic rock formations, thus making this waterfall as the Grand Canyon miniature found in Arizona, America. In Indonesian, “cunca wulang” means “waterfall and moon”. This waterfall is located at an altitude of 200 meters above sea level making the atmosphere of this place is very cool. At first glance, you will feel that you are in the “Grand Canyon” when arriving in this place because there is a river flow between the cliffs of large rocks. The waterfall is above the rocks and the waters come out through the gaps in the rocks.");
        mRatings2.add("8/10");

        mImageUrls2.add("https://media-cdn.tripadvisor.com/media/photo-o/0b/75/18/ce/air-terjun-lapopu-yang.jpg");
        mNames2.add("Lapopu Waterfall");
        mDescs2.add("Surrounded by big trees and lush environment, Lapopu Beach offers a soothing ambiance to visitors. The waterfall consists of several levels and it has the height of approximately 90 meters! No wonder, this natural attraction is worth photography or simply sightseeing. The next impressive feature is the presence of peaceful and refreshing natural pond located right below it. Visitors are even allowed to get and take a bath in it! Not to mention several stones are also seen where tourists can use for sitting and resting during the exploration.");
        mRatings2.add("9/10");

        mImageUrls2.add("https://media-cdn.tripadvisor.com/media/photo-m/1280/13/80/0d/3b/20180626-112645-largejpg.jpg");
        mNames2.add("Waimarang Waterfall");
        mDescs2.add("Waimarang waterfall is located in Melolo area, which is in Watu Hadang Village, Umalulu subdistrict, East Sumba District, East Nusa Tenggara Province, Indonesia. Because it is in the middle of the forest and under the abbys, visitor need extra effort to get there.");
        mRatings2.add("9/10");

        mImageUrls2.add("https://media-cdn.tripadvisor.com/media/photo-m/1280/13/d6/79/c8/natural.jpg");
        mNames2.add("Tanggedu Waterfall");
        mDescs2.add("Tanggedu Waterfall or called the Grand Canyon of East Sumba by the visitors is a waterfall  that lies in Tanggedu Village, Kanatang District, East Sumba Regency, East Nusa Tenggara Province. It has a characteristic form of rock relief that is very unique. This waterfall is less than 46 km north of the Waingapu city.");
        mRatings2.add("9/10");
        /////////////////////
        mImageUrls3.add("https://media-cdn.tripadvisor.com/media/photo-o/16/66/9f/2e/padar-island-is-hottest.jpg");
        mNames3.add("Padar Island");
        mDescs3.add("Padar Island is a remote and wild island located in the middle of the straight between Rinca Island and Komodo Island. Defended by strong currents and swell coming from the nearby Indian ocean, going to Padar Island is an adventure in itself. Hello Flores team like to call it “Neverland” and will understand why once you will be there! Steep and dry hills, cliffs falling straight into the ocean, sea eagles flying around, gigantic bays with crystal waters and many unknown pink-sand beaches are what give this place a truly unique atmosphere. A one-hour trek to the top of Padar Kecil will bring you to a breathtaking panorama overlooking Komodo National Park. Sunrise and sunset times are the best times of the day to do the trekking with endless changing color in the sky.");
        mRatings3.add("10/10");

        mImageUrls3.add("https://media-cdn.tripadvisor.com/media/photo-o/03/9b/43/72/rinca-island.jpg");
        mNames3.add("Rinca Island");
        mDescs3.add("Rinca is a rough and tumble little island located in East Nusa Tenggara, Indonesia just off the western tip of Flores. One of only a very few places to spot Komodo dragons in the wild, Rinca is often overlooked by tourists on their way to the more-popular Komodo Island. You are much more likely to spot Komodo dragons in their natural habitat on Rinca Island where there is less impact from tourism.");
        mRatings3.add("8/10");

        mImageUrls3.add("https://media-cdn.tripadvisor.com/media/photo-o/16/c3/05/42/on-top-of-kelor-island.jpg");
        mNames3.add("Kelor Island");
        mDescs3.add("Kelor Island has many features, including beautiful beaches, mountains, local activities, and calm sea. In the shorelines, you can even see some local boats and kids. The locals often come to the beach to do many fun activities like swimming, riding boats, running on the beach, and much more. That means water sports become the main activities in Kelor, so tourists need to prepare extra clothes prior to visiting the island. It is because they are likely to get wet when playing on the seashore.");
        mRatings3.add("9/10");

        mImageUrls3.add("https://media-cdn.tripadvisor.com/media/photo-m/1280/1b/3a/ae/07/kanawa-island.jpg");
        mNames3.add("Kanawa Island");
        mDescs3.add("The island of Kanawa, only some 15 km from the growing fishermen’s town of Labuan Bajo on Flores, is fringed with a bed of coral reefs teeming with colorful fish all around. Its turquoise water is exceptionally calm and clear. Swimming and snorkeling are most poular family activities here. Dive down the sea from the jetty, and meet schools of fish that cloud the stilts. Hours would pass so quietly as you are busy with all of these beach activities.");
        mRatings3.add("8/10");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_place, container, false);

        RecyclerView recyclerView_Beach = view.findViewById(R.id.recycler_view_place_fragment);
        RecyclerViewAdapter2 adapter_Beach = new RecyclerViewAdapter2(getContext(), mNames, mImageUrls,mDescs, mRatings);
        LinearLayoutManager linearLayoutManager_Beach = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView_Beach.setLayoutManager(linearLayoutManager_Beach);
        recyclerView_Beach.setAdapter(adapter_Beach);

        RecyclerView recyclerView_Nature = view.findViewById(R.id.recycler_view_place_fragment1);
        RecyclerViewAdapter2 adapter_Nature = new RecyclerViewAdapter2(getContext(), mNames1, mImageUrls1,mDescs1, mRatings1);
        LinearLayoutManager linearLayoutManager_Nature = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView_Nature.setLayoutManager(linearLayoutManager_Nature);
        recyclerView_Nature.setAdapter(adapter_Nature);

        RecyclerView recyclerView_Waterfall = view.findViewById(R.id.recycler_view_place_fragment2);
        RecyclerViewAdapter2 adapter_Waterfall = new RecyclerViewAdapter2(getContext(), mNames2, mImageUrls2,mDescs2, mRatings2);
        LinearLayoutManager linearLayoutManager_Waterfall = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView_Waterfall.setLayoutManager(linearLayoutManager_Waterfall);
        recyclerView_Waterfall.setAdapter(adapter_Waterfall);

        RecyclerView recyclerView_Island = view.findViewById(R.id.recycler_view_place_fragment3);
        RecyclerViewAdapter2 adapter_Island = new RecyclerViewAdapter2(getContext(), mNames3, mImageUrls3,mDescs3, mRatings3);
        LinearLayoutManager linearLayoutManager_most = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView_Island.setLayoutManager(linearLayoutManager_most);
        recyclerView_Island.setAdapter(adapter_Island);

        return view;
    }
}
