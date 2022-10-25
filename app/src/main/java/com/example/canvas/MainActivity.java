package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    // define the variable
    Button send_button;
    EditText send_text;
    EditText send_text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT > 21) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll()
                    .build();
            StrictMode.setThreadPolicy(policy);
        }

        send_button = findViewById(R.id.send_button_id);
        send_text = findViewById(R.id.send_text_id);
        send_text2 = findViewById(R.id.send_text_id2);

        send_button.setOnClickListener(v -> {

            String str = send_text.getText().toString();
            String str2 = send_text2.getText().toString();

            // Create the Intent object of this class Context() to Second_activity class
            Intent intent = new Intent(getApplicationContext(), Second_activity.class);

            intent.putExtra("message_key", str);
            intent.putExtra("message_key1", str2);

              Bitmap bitmap = loadBitmapFromUrl();
            Bitmap icon = BitmapFactory.decodeResource(this.getResources(),
                    R.drawable.running);
            BitmapHelper.getInstance().setBitmap(icon);
            startActivity(intent);
        });
    }

    private Bitmap loadBitmapFromUrl() {
        try {
            URL url = new URL("https://i.pinimg.com/564x/74/57/6f/74576fe9214f46822a0657d1d41f0104.jpg");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            return BitmapFactory.decodeStream(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}