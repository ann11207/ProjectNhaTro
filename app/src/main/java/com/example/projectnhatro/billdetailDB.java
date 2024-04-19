package com.example.projectnhatro;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class billdetailDB extends DBHelper{


    public billdetailDB(Context context){super(context);}

    public Boolean saveBill( int electricUse, int newElectric, int totalCash ,int oldElectric){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
//        contentValues.put("numHouse", numHouse);
        contentValues.put("electricUse", electricUse);
        contentValues.put("newElectric", newElectric);
        contentValues.put("oldElectric", oldElectric);
        contentValues.put("totalCash", totalCash);

        long result = DB.insert("cash",null,contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }

}
