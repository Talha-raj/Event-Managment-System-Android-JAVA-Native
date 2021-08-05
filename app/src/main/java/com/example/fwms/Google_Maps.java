package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.webkit.WebView;

public class Google_Maps extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps);
        getSupportActionBar().hide();
        webView=findViewById(R.id.locationmap);

    webView.loadUrl("http://www.google.com/maps/place/lat,lng");
    }
}