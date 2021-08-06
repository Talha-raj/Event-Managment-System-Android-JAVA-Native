package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class singledata extends AppCompatActivity {
Button getguests;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singledata);
        getguests=findViewById(R.id.guestlist);


        getguests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(singledata.this,Guestdata.class);
                startActivity(i);
            }
        });

    }
}