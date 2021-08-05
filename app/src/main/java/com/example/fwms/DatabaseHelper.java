package com.example.fwms;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB = "Event";
    public static final String TABLE_NAME = "Event_Register";
    public static final String COlS1 = "ID";
    public static final String COlS2 = "eventtype";
    public static final String COlS3 = "eventname";
    public static final String COlS4 = "eventtime";
    public static final String COlS5 = "guests";
    public static final String COlS6 = "contact";
    public static final String COlS7 = "Describtion";
    List<Contacts> contactsList = new ArrayList<>();

    public DatabaseHelper(Context context) {
        super(context, DB,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, eventtype TEXT, eventname TEXT, eventtime TEXT, guests TEXT,contact TEXT,Describtion TEXT)");

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }

    public List<Contacts> getAllcontacts(){

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()){
            int index1 = cursor.getColumnIndex(DatabaseHelper.COlS1);
            int id = cursor.getInt(index1);

            int index2 = cursor.getColumnIndex(DatabaseHelper.COlS2);
            String Event_Type = cursor.getString(index2);

            int index3 = cursor.getColumnIndex(DatabaseHelper.COlS3);
            String Event_name = cursor.getString(index3);


            int index5 = cursor.getColumnIndex(DatabaseHelper.COlS4);
            String Event_dattime = cursor.getString(index5);

            int index6 = cursor.getColumnIndex(DatabaseHelper.COlS6);
            String Event_contact = cursor.getString(index6);

            int index7 = cursor.getColumnIndex(DatabaseHelper.COlS7);
            String Event_describtiont = cursor.getString(index7);
            Contacts contacts = new Contacts(id,Event_Type,Event_name,Event_dattime,Event_contact,Event_describtiont);
                contactsList.add(contacts);

        }
        return contactsList;

    }






}

