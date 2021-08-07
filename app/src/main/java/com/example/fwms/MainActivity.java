package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView mangaevent,fooddata;
    ImageButton jumper;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mangaevent=findViewById(R.id.imageViewe);
        logout=findViewById(R.id.buttonlog);
        jumper=findViewById(R.id.jumplogin);
        fooddata=findViewById(R.id.foodmenue);
        mangaevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Eventsetting.class);
                startActivity(i);

            }
        });

        jumper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,UserLogin.class);
                startActivity(i);

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Login.class);
                startActivity(i);
                finish();

            }
        });

    fooddata.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent inte = new Intent(MainActivity.this,FoodOrders.class);
            startActivity(inte);
        }
    });

    }


}