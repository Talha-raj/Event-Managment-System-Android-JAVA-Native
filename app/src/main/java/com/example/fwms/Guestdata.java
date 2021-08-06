package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Guestdata extends AppCompatActivity {
    ListView guestdatalist;
    UserDatabasehelper mDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guestdata);
        guestdatalist=findViewById(R.id.guestlistview);
        getSupportActionBar().hide();

        populateListView();
    }

    private void populateListView() {
        mDatabaseHelper = new UserDatabasehelper(this);
       // universities = new Universities();

        int gre = getIntent().getIntExtra("Gre",0);




        List<String> data = mDatabaseHelper.getData(gre);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Guestdata.this, android.R.layout.simple_list_item_1, data);

        guestdatalist.setAdapter(adapter);
    }
}