package com.example.fwms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class FoodDataBasehelper extends SQLiteOpenHelper {


    public static final String DB = "fooddatabase";
    public static final String TABLE_NAME = "foodtable";
    public static final String COl1 = "OrderID";
    public static final String COl2 = "GuestName";
    public static final String COl3 = "OrderDetails";
    List<Food> foodlists = new ArrayList<>();

    public FoodDataBasehelper(Context context) {
        super(context, DB,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, GuestName TEXT,OrderDetails TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);

    }

    public boolean addDatafood(String Guestname,String orderdetail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COl2, Guestname);
        contentValues.put(COl3, orderdetail);
        Log.d(DB, "addData : Adding" + orderdetail + "to" + TABLE_NAME);
        long res = db.insert(TABLE_NAME, null, contentValues);

        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }


    public List<Food> getAllcontacts(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()){
            int index2 = cursor.getColumnIndex(FoodDataBasehelper.COl2);
            String Guestname = cursor.getString(index2);

            int index3 = cursor.getColumnIndex(FoodDataBasehelper.COl3);
            String Fooddetails = cursor.getString(index3);


            Food food = new Food(Guestname,Fooddetails);
            foodlists.add(food);

        }
        return foodlists;

    }


    public List<String> getguestlist(){
        String query = "SELECT " + COl3 + "  FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        List<String> attrStr = new Vector<String>();
        if (cursor.moveToFirst()) {
            do {
                attrStr.add(cursor.getString(cursor.getColumnIndex(COl3)));
                Arrays.toString(new List[]{attrStr});
            } while (cursor.moveToNext());
        }
        while (cursor.moveToNext()) {

        }
        return attrStr;
    }

}



