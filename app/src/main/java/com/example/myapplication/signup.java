package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signup extends AppCompatActivity {
    Button signup;
    EditText email;
    String txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Intent login = new Intent(signup.this, login.class);
        signup=findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=findViewById(R.id.email);
                txt=email.getText().toString();
                login.putExtra("email",txt);
                email=findViewById(R.id.password);
                txt=email.getText().toString();
                login.putExtra("password",txt);
                startActivity(login);
                finish();
            }
        });
    }
}