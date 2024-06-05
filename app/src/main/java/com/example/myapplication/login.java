package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText email,password;
    String mail,pass;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent=getIntent();
        mail=intent.getStringExtra("email");
        pass=intent.getStringExtra("password");
        email=findViewById(R.id.logemail);
        password=findViewById(R.id.logpassword);
        login=findViewById(R.id.Login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mail.equals(email.getText().toString())){
                    if (pass.equals(password.getText().toString())) {
                        Intent Home = new Intent(login.this, dashboard.class);
                        startActivity(Home);
                        finish();
                    }
                    else
                        Toast.makeText(login.this, "InCorrect Password", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(login.this, "Incorrect Email", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup=new Intent(login.this,com.example.myapplication.signup.class);
                startActivity(signup);
                finish();
            }
        });

    }
}