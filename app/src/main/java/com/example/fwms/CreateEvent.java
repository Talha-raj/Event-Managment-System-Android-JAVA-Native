package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class CreateEvent extends AppCompatActivity {

    Button saveevent;
    EditText name, type, noofguest, contact, desc;
    DatePicker time;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        getSupportActionBar().hide();
        saveevent = findViewById(R.id.eventdone);
        name = findViewById(R.id.ename);
        type = findViewById(R.id.etype);
        time = findViewById(R.id.etime);
        noofguest = findViewById(R.id.eguest);
        contact = findViewById(R.id.econtact);
        desc = findViewById(R.id.edes);
        openHelper=new DatabaseHelper(this);


        saveevent.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String dataname = name.getText().toString();
                String dataetype = type.getText().toString();
                String dataetime = time.getDayOfMonth()+"/"+time.getMonth()+"/"+time.getYear();
                String dataeguest= noofguest.getText().toString();
                String dataecontact= contact.getText().toString();
                String dataedesc= desc.getText().toString();
                db=openHelper.getWritableDatabase();
                if(name.length() !=0 && type.length() !=0
                        && noofguest.length() !=0 && contact.length() !=0 && desc.length() !=0){
                    insertData(dataname, dataetype, dataetime,dataeguest,dataecontact,dataedesc);
                    Toast.makeText(getApplicationContext(), "Event Created Successfully", Toast.LENGTH_LONG).show();
                    name.setText("");
                    type.setText("");
                    noofguest.setText("");
                    contact.setText("");
                    desc.setText("");
//                    Intent i = new Intent(CreateEvent.this,ViewEvent.class);
//                    startActivity(i);
//                    finish();


                }
                else {
                    Toast.makeText(CreateEvent.this, "Please Fill All Fields To Create Event", Toast.LENGTH_SHORT).show();
                }



            }

        });


    }

    private void insertData(String dataname, String dataetype, String dataetime, String dataeguest, String dataecontact, String dataedesc) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COlS2, dataname);
        contentValues.put(DatabaseHelper.COlS3, dataetype);
        contentValues.put(DatabaseHelper.COlS4, dataetime);
        contentValues.put(DatabaseHelper.COlS5, dataeguest);
        contentValues.put(DatabaseHelper.COlS6, dataecontact);
        contentValues.put(DatabaseHelper.COlS7, dataedesc);
        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }

}