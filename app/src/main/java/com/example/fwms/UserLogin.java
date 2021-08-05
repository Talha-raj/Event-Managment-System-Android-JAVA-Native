package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserLogin extends AppCompatActivity {
TextView newaccount;
EditText cuseremail,checkuserpassword;
Button button;
UserDatabasehelper mDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
            newaccount=findViewById(R.id.create_useracc);
            cuseremail=findViewById(R.id.useremail);
            checkuserpassword=findViewById(R.id.userpass);
            button=findViewById(R.id.userlogin);
           mDatabaseHelper = new UserDatabasehelper(this);

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
                          Toast.makeText(UserLogin.this, "Login Successfull", Toast.LENGTH_SHORT).show();

                          Intent inte = new  Intent(UserLogin.this,UserDashboard.class);
                          startActivity(inte);
                      }
                  }
              }
          });
    }
}