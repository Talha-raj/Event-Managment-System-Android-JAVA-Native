package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splashscreen extends AppCompatActivity {

    Thread timer;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        timer = new Thread(){
            public void run(){
                try {
                    synchronized (this){
                        wait(5000);
                    }
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    Intent inte = new Intent(Splashscreen.this,Login.class);
                    startActivity(inte);
                    finish();
                }
            }
        };


    }
}