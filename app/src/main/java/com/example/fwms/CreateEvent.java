package com.example.fwms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class CreateEvent extends AppCompatActivity {

    Button saveevent;
    EditText name, type, noofguest, contact, desc ,Event_location;
    DatePicker time;
    SQLiteOpenHelper openHelper;

    FusedLocationProviderClient locationclient;
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
        Event_location = findViewById(R.id.elocation);
        openHelper = new DatabaseHelper(this);

        locationclient = LocationServices.getFusedLocationProviderClient(this);

        Event_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(CreateEvent.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    getlocation();
                } else {
                    ActivityCompat.requestPermissions(CreateEvent.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }
            }
        });


        saveevent.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String dataname = name.getText().toString();
                String dataetype = type.getText().toString();
                String dataetime = time.getDayOfMonth() + "/" + time.getMonth() + "/" + time.getYear();
                String dataeguest = noofguest.getText().toString();
                String dataecontact = contact.getText().toString();
                String dataedesc = desc.getText().toString();
                String dataelocation = Event_location.getText().toString();
                db = openHelper.getWritableDatabase();
                if (name.length() != 0 && type.length() != 0
                        && noofguest.length() != 0 && contact.length() != 0 && desc.length() != 0) {
                    insertData(dataname, dataetype, dataetime, dataeguest,dataelocation, dataecontact, dataedesc);
                    Toast.makeText(getApplicationContext(), "Event Created Successfully", Toast.LENGTH_LONG).show();
                    name.setText("");
                    type.setText("");
                    noofguest.setText("");
                    contact.setText("");
                    desc.setText("");
                    Intent i = new Intent(CreateEvent.this,ViewEvent.class);
                    startActivity(i);
                    finish();


                } else {
                    Toast.makeText(CreateEvent.this, "Please Fill All Fields To Create Event", Toast.LENGTH_SHORT).show();
                }


            }

        });


    }

    private void getlocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationclient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location llocation = task.getResult();
                if(llocation != null){
                    try {
                        Geocoder geocoder = new Geocoder(CreateEvent.this, Locale.getDefault());
                        List<Address> addresses = geocoder.getFromLocation(llocation.getLatitude(),llocation.getLongitude(),1);
                        Event_location.setText(addresses.get(0).getLatitude()+","+addresses.get(0).getLongitude());
                        Event_location.setEnabled(false);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }

    private void insertData(String dataname, String dataetype, String dataetime, String dataeguest, String dataecontact,String dataelocation, String dataedesc) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COlS2, dataname);
        contentValues.put(DatabaseHelper.COlS3, dataetype);
        contentValues.put(DatabaseHelper.COlS4, dataetime);
        contentValues.put(DatabaseHelper.COlS5, dataeguest);
        contentValues.put(DatabaseHelper.COlS6, dataecontact);
        contentValues.put(DatabaseHelper.COlS7, dataedesc);
        contentValues.put(DatabaseHelper.COlS8, dataelocation);
        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }

}