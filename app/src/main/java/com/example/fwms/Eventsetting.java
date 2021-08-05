package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Eventsetting extends AppCompatActivity {
ImageView createevent,viewevents,deleteevent,update_e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventsetting);
        getSupportActionBar().hide();
        createevent=findViewById(R.id.createev);
        viewevents=findViewById(R.id.viewev);
        deleteevent=findViewById(R.id.delteev);
        update_e=findViewById(R.id.updateevent);

        createevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Eventsetting.this,CreateEvent.class);
                startActivity(i);
            }
        });

        viewevents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Eventsetting.this,ViewEvent.class);
                startActivity(i);
            }
        });

        deleteevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Eventsetting.this,DeleteEvent.class);
                startActivity(i);
            }
        });

        update_e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Eventsetting.this,UpdateEvent.class);
                startActivity(i);
            }
        });




    }
}