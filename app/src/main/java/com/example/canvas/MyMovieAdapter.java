package com.example.canvas;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class MyMovieAdapter extends RecyclerView.Adapter<MyMovieAdapter.ViewHolder> {

    MyMovieData[] myMovieData;
    Context context;

    public MyMovieAdapter(MyMovieData[] myMovieData, CardImageView activity) {
        this.myMovieData = myMovieData;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.movie_item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MyMovieData myMovieDataList = myMovieData[position];
        //    holder.movieImage.setImageResource(myMovieDataList.getMovieImage());

        // BitmapHelper.getInstance().setBitmap(icon);

        Bitmap bitmap2 = BitmapFactory.decodeResource(context.getResources(),
                myMovieDataList.getMovieImage());

        Resources resources = context.getResources();
        float scale = resources.getDisplayMetrics().density;

        android.graphics.Bitmap.Config bitmapConfig = bitmap2.getConfig();
        if (bitmapConfig == null) {
            bitmapConfig = android.graphics.Bitmap.Config.ARGB_8888;
        }

        bitmap2 = bitmap2.copy(bitmapConfig, true);

        Canvas canvas = new Canvas(bitmap2);

        Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize((int) (100 * scale));
        textPaint.setTypeface(ResourcesCompat.getFont(context.getApplicationContext(), R.font.ralewaythin));
        textPaint.setColor(Color.rgb(6, 94, 105));
        int xPos = (canvas.getWidth() / 2);
        int yPos = (canvas.getHeight() / 2);

        canvas.drawText(myMovieDataList.getMovieName(), xPos, yPos, textPaint);

        holder.movieImage.setImageBitmap(bitmap2);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, myMovieDataList.getMovieName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return myMovieData.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView movieImage;
        TextView textViewName;
        TextView textViewDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.imageview);

        }
    }

}
