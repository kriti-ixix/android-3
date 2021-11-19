package com.kriti.android3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyContext extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_context);
        button = findViewById(R.id.contextButton);
        registerForContextMenu(button);

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                openContextMenu(v);
                return true;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.long_press_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.contextOne)
        {
            Toast.makeText(MyContext.this, "Hi", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.contextTwo)
        {
            Toast.makeText(MyContext.this, "How are you?", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}