package com.kriti.android3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    TextView emailTextView, passwordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        emailTextView = findViewById(R.id.emailTextView);
        passwordTextView = findViewById(R.id.passwordTextView);

//        Intent intent = getIntent();
//        String em = intent.getStringExtra("email");
//        String pass = intent.getStringExtra("password");

        SharedPreferences sp = getSharedPreferences("login demo", MODE_PRIVATE);
        String em = sp.getString("username", "User");
        String pass = sp.getString("userpassword", "None");

        emailTextView.setText(em);
        passwordTextView.setText(pass);
    }
}