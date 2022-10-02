package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;

import com.squareup.picasso.Picasso;

public class CardImageView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_image_view);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        SnapHelper snapHelper = new PagerSnapHelper();
        MyMovieData[] myMovieData = new MyMovieData[]{
                new MyMovieData("Avengers", "2019 film", R.drawable.avenger),
                new MyMovieData("Venom", "2018 film", R.drawable.venom),
                new MyMovieData("Batman Begins", "2005 film", R.drawable.batman),
                new MyMovieData("Jumanji", "2019 film", R.drawable.jumanji),
                new MyMovieData("Hulk", "2003 film", R.drawable.hulk),
                new MyMovieData("Hulk", "2003 film", R.drawable.preto),

        };

        MyMovieAdapter myMovieAdapter = new MyMovieAdapter(myMovieData, CardImageView.this);
        recyclerView.setAdapter(myMovieAdapter);
        snapHelper.attachToRecyclerView(recyclerView);

    }
}