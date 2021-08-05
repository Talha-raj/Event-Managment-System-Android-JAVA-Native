package com.example.fwms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class UserDatabasehelper extends SQLiteOpenHelper {

    public static final String DB = "User_DB";
    public static final String TABLE_NAME = "User_Register";
    public static final String COl1 = "ID";
    public static final String COl2 = "Name";
    public static final String COl3 = "Email";
    public static final String COls4 = "Contact";
    public static final String COl5 = "Password";



    public UserDatabasehelper(Context context) {
        super(context, DB,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Email TEXT, Password TEXT,Contact TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);

    }

    public boolean addData(String names, String Email,String contact, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COl2, names);
        contentValues.put(COl3, Email);
        contentValues.put(COls4, contact);
        contentValues.put(COl5, password);
        Log.d(DB, "addData : Adding" + names + "to" + TABLE_NAME);
        long res = db.insert(TABLE_NAME, null, contentValues);

        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkemail (String Email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM User_Register WHERE Email = ?", new String[]{Email});
            if(cursor.getCount()>0){
                return true;
        }
        else {
            return false;
        }
    }

    public Boolean checkuserpassword (String Email,String Password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM User_Register WHERE Email = ? AND Password =?", new String[]{Email,Password});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }


}
