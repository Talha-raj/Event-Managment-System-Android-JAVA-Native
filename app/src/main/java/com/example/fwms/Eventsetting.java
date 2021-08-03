package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Eventsetting extends AppCompatActivity {
ImageView createevent,viewevents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventsetting);
        createevent=findViewById(R.id.createev);
        viewevents=findViewById(R.id.viewevent);

//        viewevents.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(Eventsetting.this,ViewEvent.class);
//                startActivity(i);
//                finish();
//            }
//        });

        createevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Eventsetting.this,CreateEvent.class);
                startActivity(in);
            }
        });

    }
}