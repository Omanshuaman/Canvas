package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Fit_Image extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fit_image);

        imageView = findViewById(R.id.imageviewq);

      //  Picasso.get().load(R.drawable.hulk).resize(8000, 5000).onlyScaleDown().into(imageView);

        Picasso.get().load(R.drawable.pexels).resize(2000, 5000).centerCrop().into(imageView);

    }
}