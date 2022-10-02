package com.example.canvas;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class Second_activity extends AppCompatActivity {
    ImageView imageView;
    StorageReference storageReference;
    StorageReference storageReference1;

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

        Drawable myDrawable = getResources().getDrawable(R.drawable.avenger);
        //   Bitmap myLogo = ((BitmapDrawable) myDrawable).getBitmap();

        Canvas canvas = new Canvas(bitmap2);

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

//        imageView.setImageBitmap(overlay(bitmap2, myLogo));
        storageReference = FirebaseStorage.getInstance().getReference("images/" + "Preto" + ".png");
        storageReference1 = FirebaseStorage.getInstance().getReference("images/" + "avenger" + ".jpeg");

        try {
            File localFile = File.createTempFile("tempFile", ".png");
            storageReference.getFile(localFile)
                    .addOnSuccessListener(taskSnapshot -> {

                        Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                        Bitmap.Config bitmapConfig1 = bitmap.getConfig();
                        if (bitmapConfig1 == null) {
                            bitmapConfig1 = Bitmap.Config.ARGB_8888;
                        }
                        bitmap = bitmap.copy(bitmapConfig1, true);
                        Canvas canvas1 = new Canvas(bitmap);
                        canvas1.drawText("FAITHHHHHHHHHHHH", xPos7, yPos7, textPaint7);

                        try {
                            File localFile1 = File.createTempFile("tempFile1", ".png");
                            Bitmap finalBitmap = bitmap;
                            storageReference1.getFile(localFile1)
                                    .addOnSuccessListener(taskSnapshot1 -> {
                                        Bitmap myLogo = BitmapFactory.decodeFile(localFile1.getAbsolutePath());
                                        imageView.setImageBitmap(overlay(finalBitmap, myLogo));
                                    }).addOnFailureListener(e -> Toast.makeText(Second_activity.this, "No", Toast.LENGTH_SHORT).show());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).addOnFailureListener(e -> Toast.makeText(Second_activity.this, "No", Toast.LENGTH_SHORT).show());
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private Bitmap overlay(Bitmap bmp1, Bitmap bmp2) {
        Bitmap bmOverlay = Bitmap.createBitmap(bmp1.getWidth(), bmp1.getHeight(), bmp1.getConfig());
        Canvas canvas = new Canvas(bmOverlay);
        canvas.drawBitmap(bmp1, new Matrix(), null);
        canvas.drawBitmap(bmp2, 100, 200, null);

        return bmOverlay;
    }
}
