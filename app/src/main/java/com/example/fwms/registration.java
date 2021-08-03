package com.example.fwms;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import java.util.HashMap;
import java.util.Map;

public class registration extends AppCompatActivity {
TextView textview;
Button register;
EditText txtname,txtemail,txtpassword,txtcontact;
AwesomeValidation mAwesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
ConnectivityManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();
        textview=findViewById(R.id.alreadyacc);
        txtname=findViewById(R.id.reg_name);
        txtemail=findViewById(R.id.reg_email);
        txtpassword=findViewById(R.id.reg_pass);
        txtcontact=findViewById(R.id.reg_pass);
        register=findViewById(R.id.registerbtn);

        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
        mAwesomeValidation.addValidation(this, R.id.reg_contact, RegexTemplate.TELEPHONE, R.string.mobileerror);
        mAwesomeValidation.addValidation(this, R.id.reg_name, "[a-zA-Z\\s]+", R.string.nameerror);
        mAwesomeValidation.addValidation(this, R.id.reg_email, android.util.Patterns.EMAIL_ADDRESS, R.string.emailerror);
        mAwesomeValidation.addValidation(this, R.id.reg_pass, regexPassword, R.string.passworderror);




        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
                try {
                    if(manager==null || manager.getActiveNetworkInfo().isConnected()) {
                        if( mAwesomeValidation.validate()){
                            Adduser(txtname.getText().toString(),txtemail.getText().toString(),txtcontact.getText().toString(),txtpassword.getText().toString());
                        }
                        else {
                            Toast.makeText(registration.this, "Fill Information Correctly", Toast.LENGTH_LONG).show();
                        }

                    }
                    else {
                        Toast.makeText(registration.this, "wait", Toast.LENGTH_LONG).show();
                    }

                }
                catch (Exception e){

                    Toast.makeText(registration.this, "Check Your Internet", Toast.LENGTH_SHORT).show();

                }




//                if(mAwesomeValidation.validate())
//                {
//                    Adduser(textname.getText().toString(),textemail.getText().toString(),textcontact.getText().toString(),textpassword.getText().toString());
//                } else {
//                    Toast.makeText(MainActivity.this, "Fill Information Correctly", Toast.LENGTH_LONG).show();
//                }

            }
        });





        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(registration.this,Login.class);
                startActivity(i);
                finish();
            }
        });




    }

    private void Adduser(final String Name, final String Email, final String Contact, final String Pass) {

        {
            StringRequest request=new StringRequest(Request.Method.POST, "https://vocalic-successes.000webhostapp.com/register.php", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(registration.this, response, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(registration.this,Login.class);
                    startActivity(intent);
                    finish();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(registration.this,error.getMessage(), Toast.LENGTH_LONG).show();
                }
            }){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> map=new HashMap<>();
                    map.put("name",Name);
                    map.put("email",Email);
                    map.put("contact",Contact);
                    map.put("password",Pass);
                    return map;
                }
            };
            RequestQueue queue= Volley.newRequestQueue(this);
            queue.add(request);
        }
    }
}