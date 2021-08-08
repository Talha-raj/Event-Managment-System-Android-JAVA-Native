package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserLogin extends AppCompatActivity {
TextView newaccount;
EditText cuseremail,checkuserpassword,edemail,edpass;
Button button;
UserDatabasehelper mDatabaseHelper;
    SharedPreferences sh2;
    SharedPreferences.Editor editor2;
    boolean isLoggedIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        getSupportActionBar().hide();
            newaccount=findViewById(R.id.create_useracc);
            cuseremail=findViewById(R.id.useremail);
            checkuserpassword=findViewById(R.id.userpass);
            button=findViewById(R.id.userlogin);
           mDatabaseHelper = new UserDatabasehelper(this);
        sh2=getSharedPreferences("DATA",MODE_PRIVATE);
        editor2=sh2.edit();
        cuseremail.setText(sh2.getString("email",""));
        checkuserpassword.setText(sh2.getString("password",""));
        isLoggedIn=sh2.getBoolean("isLoggedIn",false);

        if(isLoggedIn){
            Intent inte = new  Intent(UserLogin.this,UserDashboard.class);
            startActivity(inte);
            finish();
            return;
        }

          newaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLogin.this,UserRegister.class);
                startActivity(intent);
            }
        });

          button.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  String uEmail = cuseremail.getText().toString();
                  String uPassword = checkuserpassword.getText().toString();

                  if(uEmail.equals("") || uPassword.equals("")){
                      Toast.makeText(UserLogin.this, "Please Input Values to login", Toast.LENGTH_SHORT).show();
                  }
                  else {
                      Boolean checkuserpass = mDatabaseHelper.checkuserpassword(uEmail,uPassword);
                      if(checkuserpass==true){

                          editor2.putString("email", uEmail);
                          editor2.putString("password", uPassword);
                          editor2.putBoolean("isLoggedIn", true);
                          editor2.apply();

                          Toast.makeText(UserLogin.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                          Intent inte = new  Intent(UserLogin.this,UserDashboard.class);
                          startActivity(inte);
                      }
                      else {
                          Toast.makeText(UserLogin.this, "Email or Password is Incorrect", Toast.LENGTH_LONG).show();
                                cuseremail.setText("");
                                checkuserpassword.setText("");
                      }
                  }
              }
          });


    }
}