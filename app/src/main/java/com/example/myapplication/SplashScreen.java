package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {
    ProgressBar pb;
    int count;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Intent intent=new Intent(SplashScreen.this,signup.class);
        pb = findViewById(R.id.pb);

        // Automatically increase progress every 100 milliseconds
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                count++;
                if (count==100) {
                    startActivity(intent);
                    finish();
                }
                pb.setProgress(count);
                handler.postDelayed(this, 5); // Repeat every 100 milliseconds
            }
        }, 100); // Start after 100 milliseconds
    }


}