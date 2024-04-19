package com.example.projectnhatro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class rentDB extends DBHelper{

    private static rentDB instance;
    public rentDB(Context context) {
        super(context);
    }
//    public static synchronized rentDB getInstance(Context context) {
//        if (instance == null) {
//            instance = new rentDB(context.getApplicationContext());
//        }
//        return instance;
//    }


    public boolean addRenter(String rentName, String numHouse, String rentDate, String nameFirstLast) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        Cursor cursor = DB.rawQuery("SELECT * FROM renter WHERE rentName = ?", new String[]{rentName});
        if (cursor.getCount() > 0) {

            cursor.close();
            return false;
        }
        cursor.close();

        contentValues.put("rentName", rentName);
        contentValues.put("nameFirstLast", nameFirstLast);
        contentValues.put("numHouse", numHouse);
        contentValues.put("rentDate", rentDate);

        long result = DB.insert("renter", null, contentValues);


        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public Boolean updateRenter(String rentName, String numHouse, String rentDate, String nameFirstLast) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("rentName", rentName);
        contentValues.put("nameFirstLast", nameFirstLast);
        contentValues.put("numHouse", numHouse);
        contentValues.put("rentDate", rentDate);

        Cursor cursor = DB.rawQuery("Select * from renter where rentName =?", new String[]{rentName});

        long result = DB.update("renter", contentValues, "rentName =?", new String[]{rentName});

        if (cursor.getCount() > 0) {
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


    public Boolean deleteRenter(String rentName) {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from renter where rentName =?", new String[]{rentName});

        long result = DB.delete("renter", "rentName =?", new String[]{rentName});

        if (cursor.getCount() > 0) {
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


    public Cursor getRenter() {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from renter", null);

        return cursor;
    }

}

