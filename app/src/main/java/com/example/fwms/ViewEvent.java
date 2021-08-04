package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ViewEvent extends AppCompatActivity {
RecyclerView rview;
contactadapter contactsAdapter;
RecyclerView.LayoutManager layoutManager;
List<Contacts> contactsList = new ArrayList<>();
DatabaseHelper databaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event);
        getSupportActionBar().hide();
        databaseAdapter = new DatabaseHelper(this);
        contactsList = databaseAdapter.getAllcontacts();
        rview = findViewById(R.id.viewevent);
        rview.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        contactsAdapter = new contactadapter(this,contactsList , rview);
        rview.setAdapter(contactsAdapter);
        rview.setLayoutManager(layoutManager);

    }
}