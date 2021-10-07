package com.kriti.android3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText emailText = findViewById(R.id.emailEditText);
        EditText passwordText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Checking", "Listener is activated");

                String email = emailText.getText().toString();
                String password = passwordText.getText().toString();

                SharedPreferences sp = getSharedPreferences("login demo", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();

                Log.d("Details", email);
                Log.d("Details", password);

                editor.putString("username", email);
                editor.putString("userpassword", password);

                editor.apply();

                Intent intent = new Intent(Login.this, Home.class);
//                intent.putExtra("email", email);
//                intent.putExtra("password", password);
                startActivity(intent);
            }
        });
    }
}