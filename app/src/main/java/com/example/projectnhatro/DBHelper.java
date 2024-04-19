package com.example.projectnhatro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.Console;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "login.db";

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {

        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        MyDB.execSQL("create Table renter(id INTEGER PRIMARY KEY AUTOINCREMENT, rentName TEXT , numHouse TEXT , rentDate TEXT, nameFirstLast TEXT )");
        MyDB.execSQL("create Table cash(numHouse Text, electricUse INTEGER, newElectric INTEGER, oldElectric INTEGER, totalCash INTEGER, FOREIGN KEY (numHouse) REFERENCES renter(numHouse))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {

        MyDB.execSQL("drop Table if exists users");

        MyDB.execSQL("drop Table if exists renter");

        MyDB.execSQL("drop Table if exists cash");

        onCreate(MyDB);
    }


}