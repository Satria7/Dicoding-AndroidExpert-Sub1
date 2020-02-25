package com.putrasamawa.dicodingmade1;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.putrasamawa.dicodingmade1.Adapter.ExampleAdapter;
import com.putrasamawa.dicodingmade1.Item.Item;
import java.util.ArrayList;

//* Satria Junanda *//

public class MainActivity extends AppCompatActivity {
    private ArrayList<Item> mExampleList;

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ImageView settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        settings=(ImageView)findViewById(R.id.pengaturan);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.ACTION_LOCALE_SETTINGS));
            }
        });

        createExampleList();
        buildRecyclerView();


    }

    public void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new Item(R.drawable.poster_avengerinfinity, "Avenger Infinity War",getString(R.string.endgame)));
        mExampleList.add(new Item(R.drawable.poster_aquaman, "Aquaman", getString(R.string.aquaman)));
        mExampleList.add(new Item(R.drawable.poster_bumblebee, "Bumblebee", getString(R.string.bumblebee)));
        mExampleList.add(new Item(R.drawable.poster_robinhood, "Robin Hood", getString(R.string.robinhood)));
        mExampleList.add(new Item(R.drawable.poster_venom, "Venom", getString(R.string.venom)));
        mExampleList.add(new Item(R.drawable.poster_spiderman, "Spider Man Into Spider-Verse", getString(R.string.spiderman)));
        mExampleList.add(new Item(R.drawable.poster_dragon, "How to Train Your Dragon", getString(R.string.dragon)));
        mExampleList.add(new Item(R.drawable.poster_glass, "Glass", getString(R.string.glass)));
        mExampleList.add(new Item(R.drawable.poster_hunterkiller, "Hunter Killer", getString(R.string.hunter)));
        mExampleList.add(new Item(R.drawable.poster_birdbox, "Bird Box", getString(R.string.bird)));
        mExampleList.add(new Item(R.drawable.poster_a_star, "A Star Is Born", getString(R.string.star)));
        mExampleList.add(new Item(R.drawable.poster_preman, "Preman Pensiun", getString(R.string.preman)));
    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("Example Item", mExampleList.get(position));

                startActivity(intent);
            }
        });
    }
}

//* Satria Junanda *//