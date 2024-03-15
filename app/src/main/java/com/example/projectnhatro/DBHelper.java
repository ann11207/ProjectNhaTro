package com.example.projectnhatro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static  final String DBNAME = "login.db";

    public DBHelper(Context context) {
        super(context,"Login.db",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {

        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {

        MyDB.execSQL("drop Table if exists users");

    }


}
