package com.kriti.android3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {

    Button button; SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        button = findViewById(R.id.loginButton);
        sp = getSharedPreferences("login demo", MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = sp.getString("username", "none");

                if (userName.equals("none"))
                {
                    //No user is logged in
                    Intent in = new Intent(Welcome.this, Login.class);
                    startActivity(in);
                }
                else
                {
                    //Some user is logged in
                    Intent in = new Intent(Welcome.this, Home.class);
                    startActivity(in);
                }
            }
        });
    }
}