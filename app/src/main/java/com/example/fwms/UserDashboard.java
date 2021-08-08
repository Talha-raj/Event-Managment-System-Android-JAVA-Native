package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserDashboard extends AppCompatActivity {
Button logout;
    SharedPreferences sharedPreferences3;
    SharedPreferences.Editor editor3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        getSupportActionBar().hide();
        logout=findViewById(R.id.userlogout);
        sharedPreferences3=getSharedPreferences("DATA",MODE_PRIVATE);
        editor3=sharedPreferences3.edit();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor3.clear();
                editor3.apply();
                Intent i = new Intent(UserDashboard.this,UserLogin.class);
                startActivity(i);
                finish();

            }
        });
    }

}