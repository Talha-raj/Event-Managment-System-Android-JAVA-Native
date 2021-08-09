package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView mangaevent,fooddata,location;
    ImageButton jumper;
    Button logout;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mangaevent=findViewById(R.id.imageViewe);
        logout=findViewById(R.id.buttonlog);
        location=findViewById(R.id.locationimg);
        jumper=findViewById(R.id.jumplogin);
        fooddata=findViewById(R.id.foodmenue);
        sharedPreferences=getSharedPreferences("DATA",MODE_PRIVATE);
        editor=sharedPreferences.edit();
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
                editor.clear();
                editor.apply();
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

    location.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MainActivity.this,Google_Maps.class);
            startActivity(i);
        }
    });

    }

}