package com.kriti.android3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileHandling extends AppCompatActivity implements View.OnClickListener {

    EditText editText; Button readButton, writeButton;
    static final String FILENAME = "MyFile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_handling);

        editText = findViewById(R.id.editTextFile);
        readButton = findViewById(R.id.readButton);
        writeButton = findViewById(R.id.writeButton);

        readButton.setOnClickListener(this);
        writeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        int id = view.getId();

        if (id==R.id.readButton)
        {
            try
            {
                File file = new File(this.getFilesDir() + "/" + FILENAME);
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String output = "", line;

                while ((line = br.readLine()) != null)
                {
                    output += line;
                    output += "\n";
                }

                editText.setText(output);

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        else if (id==R.id.writeButton)
        {
            try
            {
                File file = new File(this.getFilesDir() + "/" + FILENAME);
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                String input = editText.getText().toString();
                bw.write(input);
                bw.flush();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}