package com.kriti.android3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                
                SharedPreferences sp = getSharedPreferences("login demo", MODE_PRIVATE);
                String em = sp.getString("username", "User");
                String pass = sp.getString("userpassword", "None");
                if(em.equals("User"))
                {
                    Intent intent = new Intent(SplashScreen.this,Login.class);
                    startActivity(intent);
                    finish();
                }
                else 
                    {
                    Intent intent = new Intent (SplashScreen.this, RandomPhoto.class);
                    startActivity(intent);
                    finish();

                }

            }
        };

        handler.postDelayed(run, 3000);

    }
}