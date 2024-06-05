package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class convert extends AppCompatActivity {
    Button btn;
    Spinner spnr;
    EditText temp;
    TextView ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        btn = findViewById(R.id.equal);
        spnr = findViewById(R.id.convert);
        temp = findViewById(R.id.temval);
        ans = findViewById(R.id.ans);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (temp.getText().toString().equals(""))
                    Toast.makeText(convert.this, "Enter Value to convert", Toast.LENGTH_SHORT).show();
                else {
                    if (spnr.getSelectedItem().toString().equals("celsius to fahrenheit")) {
                        int a = Integer.parseInt(temp.getText().toString());
                        a = (a * 9 / 5) + 32;
                        ans.setText(a + " Fahrenheit");
                    } else {
                        int a = Integer.parseInt(temp.getText().toString());
                        a = (a - 32) * 5 / 9;
                        ans.setText(a + " Celsius");
                    }
                }
            }
        });
    }
}