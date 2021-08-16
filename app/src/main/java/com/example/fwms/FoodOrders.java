package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FoodOrders extends AppCompatActivity {
    FoodDataBasehelper fdbhelper;
    RecyclerView rvfood;
    foodviewcontactadt foodviewcontactadt;
    RecyclerView.LayoutManager layoutManager;
    List<Food> foodlists = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_food_orders);
        fdbhelper = new FoodDataBasehelper(FoodOrders.this);
        foodlists = fdbhelper.getAllcontacts();
        rvfood = findViewById(R.id.foodviewlist);
        rvfood.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvfood.setLayoutManager(layoutManager);
        foodviewcontactadt = new foodviewcontactadt(this,foodlists,rvfood);
        rvfood.setAdapter(foodviewcontactadt);
        //populateListView();
    }


//    private void populateListView() {
//        Cursor data = fdbhelper.getData();
//        ArrayList<String> listdata = new ArrayList<>();
//        while (data.moveToNext()){
//            listdata.add(data.getString(1));
//        }
//        ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, listdata);
//        foodorderlist.setAdapter(adapter);
//    }

}