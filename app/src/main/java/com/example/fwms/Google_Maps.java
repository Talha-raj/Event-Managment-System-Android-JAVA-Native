package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class Google_Maps extends AppCompatActivity {
   WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps);
        getSupportActionBar().hide();
        webView=findViewById(R.id.locationmap);
        Bundle data=getIntent().getExtras();
        getSupportActionBar().hide();
        try {
            webView.loadUrl("http://maps.google.com/maps?z=12&t=m&q=loc:"+data.getString("locationdata"));
        }
        catch (Exception e){
            webView.loadUrl("http://maps.google.com/maps");
        }

        webView.setWebViewClient(new MyWebClient());
        webView.getSettings().setJavaScriptEnabled(true);

    }

    class MyWebClient extends WebViewClient
    {
        ProgressDialog dialog=new ProgressDialog(Google_Maps.this);

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            dialog.setMessage("Loading Location...");
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            dialog.dismiss();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            webView.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}
