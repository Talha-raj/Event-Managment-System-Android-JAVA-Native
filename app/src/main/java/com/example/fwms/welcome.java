package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class welcome extends AppCompatActivity {
Button org,user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getSupportActionBar().hide();
        org=findViewById(R.id.organiser);
        user=findViewById(R.id.user);
        SharedPreferences preferences = getSharedPreferences("Pref",MODE_PRIVATE);
        String Firsttime = preferences.getString("Firsttimelaunch","");

        if(Firsttime.equals("Yes")){
            Intent intent = new Intent(welcome.this,Login.class);
            startActivity(intent);
            finish();
        }
        else {

            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("Firsttimelaunch","Yes");
            editor.apply();
        }

        org.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(welcome.this, Login.class);
                startActivity(i);
                finish();
            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(welcome.this, UserLogin.class);
                startActivity(i);
                finish();
            }
        });

    }



}