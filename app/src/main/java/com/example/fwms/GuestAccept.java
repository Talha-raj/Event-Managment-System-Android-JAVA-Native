package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class GuestAccept extends AppCompatActivity {
    FoodDataBasehelper fdbhelper;
ListView acceptguests;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_accept);
        acceptguests=findViewById(R.id.acceptguest);
        listsetup();

    }

    private void listsetup() {
        fdbhelper = new FoodDataBasehelper(this);
        //int gre = getIntent().getIntExtra("Gre",0);
        List<String> data = fdbhelper.getguestlist();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(GuestAccept.this, android.R.layout.simple_list_item_1, data);
        acceptguests.setAdapter(adapter);
    }


}