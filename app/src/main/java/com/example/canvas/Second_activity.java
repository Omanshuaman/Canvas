package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

public class Second_activity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        imageView = findViewById(R.id.secondActivity);

        // create the get Intent object
        Intent intent = getIntent();

        String str = intent.getStringExtra("message_key");
        String str2 = intent.getStringExtra("message_key1");

        Resources resources = Second_activity.this.getResources();
        float scale = resources.getDisplayMetrics().density;

        Bitmap bitmap2 = BitmapHelper.getInstance().getBitmap();

        android.graphics.Bitmap.Config bitmapConfig = bitmap2.getConfig();
        if (bitmapConfig == null) {
            bitmapConfig = android.graphics.Bitmap.Config.ARGB_8888;
        }

        bitmap2 = bitmap2.copy(bitmapConfig, true);

        Canvas canvas = new Canvas(bitmap2);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.rgb(61, 61, 61));
        paint.setTextSize((int) (14 * scale));
        paint.setShadowLayer(1f, 0f, 1f, Color.WHITE);
        paint.setTextAlign(Paint.Align.CENTER);

        canvas.drawText(str, 200, 100, paint);
        canvas.drawText(str2, 200, 150, paint);
        imageView.setImageBitmap(bitmap2);

    }
}
