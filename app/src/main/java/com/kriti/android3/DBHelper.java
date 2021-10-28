package com.kriti.android3;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper
{
    public static final String DB_NAME = "school";
    public static final String TABLE_NAME = "students";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    long addData(int rn, String n, double m)
    {
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("rollno", rn);
        cv.put("name", n);
        cv.put("marks", m);
        return sq.insert(TABLE_NAME, null, cv);
    }

    int updateData(int rn, String n)
    {
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", n);
        return sq.update(TABLE_NAME, cv, "where rollno = " + rn, null);
    }

    int deleteData(int rn)
    {
        SQLiteDatabase sq = this.getWritableDatabase();
        return sq.delete(TABLE_NAME, "where rollno = " + rn, null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (rollno integer, name text, marks double)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}
}
