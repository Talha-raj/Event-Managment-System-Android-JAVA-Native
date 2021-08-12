package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UserDashboard extends AppCompatActivity {
Button logout;
    inviteviewadapter inviteviewadapter;
    RecyclerView listinvite;
    RecyclerView.LayoutManager layoutManager;
    List<Inviteview> invitev = new ArrayList<>();
    UserDatabasehelper Udbhelper;
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
        Udbhelper = new UserDatabasehelper(UserDashboard.this);
        invitev = Udbhelper.getAllcontacts();
        listinvite = findViewById(R.id.invitelist);
        listinvite.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        listinvite.setLayoutManager(layoutManager);
        inviteviewadapter = new inviteviewadapter(this,invitev,listinvite);
        listinvite.setAdapter(inviteviewadapter);


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