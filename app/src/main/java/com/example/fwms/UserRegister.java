package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class UserRegister extends AppCompatActivity {
    Button User_register;
    EditText username,useremail,usercontact,userpassword;
    TextView already_useracc;
    UserDatabasehelper mDatabaseHelper;
    AwesomeValidation mAwesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        getSupportActionBar().hide();
        User_register=findViewById(R.id.register_userbtn);
        username=findViewById(R.id.reg_username);
        useremail=findViewById(R.id.reg_useremail);
        usercontact=findViewById(R.id.reg_usercontact);
        userpassword=findViewById(R.id.reg_userpass);
        already_useracc=findViewById(R.id.already_useracc);
        mDatabaseHelper = new UserDatabasehelper(this);

        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
        mAwesomeValidation.addValidation(this, R.id.reg_usercontact, RegexTemplate.TELEPHONE, R.string.mobileerror);
        mAwesomeValidation.addValidation(this, R.id.reg_username, "[a-zA-Z\\s]+", R.string.nameerror);
        mAwesomeValidation.addValidation(this, R.id.reg_useremail, android.util.Patterns.EMAIL_ADDRESS, R.string.emailerror);
        mAwesomeValidation.addValidation(this, R.id.reg_userpass, regexPassword, R.string.passworderror);


        User_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntryname = username.getText().toString();
                String newEntryemail = useremail.getText().toString();
                String newEntrycontact = usercontact.getText().toString();
                String newEntrypassword = userpassword.getText().toString();
                String newEntryinvitwe = "NO Invites";
                String newEntrynamev = "";
                String newEntrydate = "";
                String newEntrylocation = "";
                String newEntrycontactv = "";
                String newEntrydesc = "";



                if(mAwesomeValidation.validate()){
                    Adduserdata(newEntryname,newEntryemail,newEntrypassword,newEntrycontact,newEntryinvitwe,newEntrynamev,newEntrydate,newEntrylocation,newEntrycontactv,newEntrydesc);

                }
                else {
                    showtoast("Fill Information Correctly");
                }
            }
        });
    }



    private void Adduserdata(String newEntryname, String newEntryemail, String newEntrypassword, String newEntrycontact,String newEntryinvitwe,String newEntrynamev,String newEntrydate,String newEntrylocation,String newEntrycontactv,String newEntrydesc) {

        boolean insertData = mDatabaseHelper.addData(newEntryname,newEntryemail,newEntrycontact,newEntrypassword,newEntryinvitwe,newEntrynamev,newEntrydate,newEntrylocation,newEntrycontactv,newEntrydesc);

        if(insertData){
            showtoast("Account Created Successfully ");
            Intent in = new Intent(UserRegister.this,UserLogin.class);
            startActivity(in);
            finish();
        }
        else {
            showtoast("Fail To Create User Account");
        }
    }

    private void showtoast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    }


