package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ViewEvent extends AppCompatActivity {
RecyclerView view;
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
        view = findViewById(R.id.viewevent);
        view.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        contactsAdapter = new contactadapter(this,contactsList , view);
        view.setAdapter(contactsAdapter);
        view.setLayoutManager(layoutManager);

    }
}