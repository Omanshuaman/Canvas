package com.example.canvas;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class Second_activity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        imageView = findViewById(R.id.secondActivity);

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

        Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(525);
        textPaint.setTypeface(ResourcesCompat.getFont(this, R.font.ralewaythin));
        textPaint.setColor(Color.rgb(6, 94, 105));
        int xPos = (canvas.getWidth() / 2);
        int yPos = 800;

        Paint textPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint1.setTextAlign(Paint.Align.CENTER);
        textPaint1.setTextSize(400);
        textPaint1.setTypeface(ResourcesCompat.getFont(this, R.font.ralewaythin));
        textPaint1.setColor(Color.rgb(6, 94, 105));
        int xPos1 = (canvas.getWidth() / 2);
        int yPos1 = 1190;

        Paint textPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint2.setTextAlign(Paint.Align.CENTER);
        textPaint2.setTextSize(225);
        textPaint2.setTypeface(ResourcesCompat.getFont(this, R.font.ralewaythin));
        textPaint2.setColor(Color.rgb(6, 94, 105));
        int xPos2 = (canvas.getWidth() / 2);
        int yPos2 = 1455;

        Paint textPaint3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint3.setTextAlign(Paint.Align.CENTER);
        textPaint3.setTextSize(110);
        textPaint3.setTypeface(ResourcesCompat.getFont(this, R.font.satisfy));
        textPaint3.setColor(Color.rgb(6, 94, 105));
        int xPos3 = (canvas.getWidth() / 2);
        int yPos3 = 2000;

        Paint textPaint4 = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint4.setTextAlign(Paint.Align.CENTER);
        textPaint4.setTextSize(100);
        textPaint4.setTypeface(ResourcesCompat.getFont(this, R.font.robotoc));
        textPaint4.setColor(Color.rgb(248, 255, 235));
        int xPos4 = (canvas.getWidth() / 2);
        int yPos4 = 2750;

        Paint textPaint5 = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint5.setTextAlign(Paint.Align.CENTER);
        textPaint5.setTextSize(300);
        textPaint5.setTypeface(ResourcesCompat.getFont(this, R.font.robotoc));
        textPaint5.setColor(Color.rgb(248, 255, 235));
        int xPos5 = (canvas.getWidth() / 2);
        int yPos5 = 3050;

        Paint textPaint6 = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint6.setTextAlign(Paint.Align.CENTER);
        textPaint6.setTextSize(50);
        textPaint6.setTypeface(ResourcesCompat.getFont(this, R.font.robotoc));
        textPaint6.setColor(Color.rgb(6, 94, 105));
        int xPos6 = (canvas.getWidth() / 2);
        int yPos6 = 3150;

        Paint mPaint = new Paint();


        Paint textPaint7 = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint7.setTextAlign(Paint.Align.CENTER);
        textPaint7.setTypeface(ResourcesCompat.getFont(this, R.font.ralewaythin));
        textPaint7.setColor(Color.rgb(6, 94, 105));

        setTextSizeForWidth(textPaint7, 350F, "FAITHHHHHHHHHHHH");
        int xPos7 = (canvas.getWidth() / 2);
        int yPos7 = 800;

        canvas.drawText("FAITHHHHHHHHHHHH", xPos7, yPos7, textPaint7);
        // canvas.drawText("MOVES", xPos1, yPos1, textPaint7);
        canvas.drawText("MOUNTAINS", xPos2, yPos2, textPaint2);
        canvas.drawText("Matthew 17:20", xPos3, yPos3, textPaint3);
        canvas.drawText("DAY OF WORSHIP", xPos4, yPos4, textPaint4);
        canvas.drawText("11.26.2018", xPos5, yPos5, textPaint5);
//        canvas.drawText("Sunday | 6PM | Saint Mary's Church\n" +
//                "4453 Broad Street | Birmingham, Alabama", xPos6, yPos6, textPaint6);

        imageView.setImageBitmap(bitmap2);

    }


    private static void setTextSizeForWidth(Paint paint, float desiredWidth,
                                            String text) {

        // Pick a reasonably large value for the test. Larger values produce
        // more accurate results, but may cause problems with hardware
        // acceleration. But there are workarounds for that, too; refer to
        // http://stackoverflow.com/questions/6253528/font-size-too-large-to-fit-in-cache
        final float testTextSize = 48f;

        // Get the bounds of the text, using our testTextSize.
        //  paint.setTextSize(testTextSize);
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);

        // Calculate the desired size as a proportion of our testTextSize.
        float desiredTextSize = testTextSize * desiredWidth / bounds.width();

        // Set the paint for that size.
        paint.setTextSize(desiredTextSize);

    }
}
