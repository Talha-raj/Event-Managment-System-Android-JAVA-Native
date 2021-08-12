package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegisterFood extends AppCompatActivity {
    ImageView imageView;
    FoodDataBasehelper fdbhelper;
    Button sendf;
    EditText fooddetails,guestname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_food);
        getSupportActionBar().hide();
        imageView=findViewById(R.id.slideview);
        fdbhelper = new FoodDataBasehelper(RegisterFood.this);
        sendf=findViewById(R.id.sendfood);
        fooddetails=findViewById(R.id.regfood);
        guestname=findViewById(R.id.guestname);
        imageView.setBackgroundResource(R.drawable.foodview);
        AnimationDrawable drawable = (AnimationDrawable) imageView.getBackground();
        drawable.start();

        sendf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newguestname = guestname.getText().toString();
                String newfoodentry = fooddetails.getText().toString();

                if(newguestname.equals("") || newfoodentry.equals("")){
                    Toast.makeText(RegisterFood.this, "Please Input Values :(", Toast.LENGTH_SHORT).show();
                }
                else {
                    Addfooddata(newguestname,newfoodentry);
                }


            }
        });

    }


    private void Addfooddata(String newguestname,String newfoodentry) {


        boolean insertData = fdbhelper.addDatafood(newfoodentry,newguestname);


        if(insertData){
            showtoast("Order Registred");
            Intent in = new Intent(RegisterFood.this,UserDashboard.class);
            in.putExtra("guestname",guestname.getText().toString());
            startActivity(in);
            finish();
        }
        else {
            showtoast("Fail to Register Try Again");
        }
    }

    private void showtoast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}