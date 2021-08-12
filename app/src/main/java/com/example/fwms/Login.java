package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    Button btnlogin;
    EditText getemail,getpassword;
    TextView already;
    ConnectivityManager mmanager;
    SharedPreferences sh;
    SharedPreferences.Editor editor;
    boolean isLoggedIn;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        boolean isLoggedIn;
        btnlogin=findViewById(R.id.login);
        getemail=findViewById(R.id.check_email);
        getpassword=findViewById(R.id.check_pass);
        already = findViewById(R.id.createacc);
        sh=getSharedPreferences("DATA",MODE_PRIVATE);
        editor=sh.edit();
        getemail.setText(sh.getString("email",""));
        getpassword.setText(sh.getString("password",""));
        isLoggedIn=sh.getBoolean("isLoggedIn",false);

                if(isLoggedIn){
            Intent inte = new  Intent(Login.this,MainActivity.class);
            startActivity(inte);
            finish();
            return;
        }


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mmanager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
                try {
                    if(mmanager==null || mmanager.getActiveNetworkInfo().isConnected()) {
                        login(getemail.getText().toString(),getpassword.getText().toString());
                    }
                    else {
                        Toast.makeText(Login.this, "wait", Toast.LENGTH_SHORT).show();

                    }
                }
                catch (Exception e){
                    Toast.makeText(Login.this, "Check Your Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });


        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Login.this,registration.class);
                startActivity(i);
                finish();
            }
        });


    }

    private void login(final String Email,final String Pass) {

        StringRequest request = new StringRequest(Request.Method.POST, "https://vocalic-successes.000webhostapp.com/login.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.contains("Login Successfull")){
                //    SharedPreferences.Editor editor = getSharedPreferences("name", MODE_PRIVATE).edit();
                    editor.putString("email", Email);
                    editor.putString("password", Pass);
                    editor.putBoolean("isLoggedIn", true);
                    editor.apply();
                    Intent intent = new Intent(Login.this,MainActivity.class);
                    startActivity(intent);
                    finish();

                } else if (response.contains("Faild")) {
                    Toast.makeText(Login.this, "Email or password is incorrect", Toast.LENGTH_LONG).show();
                }
                else {

                    Toast.makeText(Login.this, "idk", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("email",Email);
                params.put("password",Pass);
                return params;
            }
        };

        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(request);


    }


}