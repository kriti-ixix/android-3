package com.kriti.android3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class StudentInf extends AppCompatActivity {

    DBHelper dbHelper; ArrayList<StdInfo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_inf);
        dbHelper = new DBHelper(this);
        list = dbHelper.getAllData();
    }
}