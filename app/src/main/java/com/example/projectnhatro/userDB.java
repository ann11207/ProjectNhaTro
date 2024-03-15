package com.example.projectnhatro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class userDB extends DBHelper{
    private static userDB instance;
    public userDB(Context context) {
        super(context);
    }
    public static synchronized userDB getInstance(Context context) {
        if (instance == null) {
            instance = new userDB(context.getApplicationContext());
        }
        return instance;
    }
    public Boolean insertData(String username, String password){

        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if (result == -1 )
            return false;
        else
            return true;
    }

    public Boolean chekusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[]{username,password});

        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
