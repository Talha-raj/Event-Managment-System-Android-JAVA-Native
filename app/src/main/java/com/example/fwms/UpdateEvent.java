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

public class UpdateEvent extends AppCompatActivity {
Button update_btn;
EditText eventtypeup,eventnameup,noofguesup,contactup,describtionup,eventidup;
DatePicker eventdattimeup;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_update_event);
        update_btn=findViewById(R.id.eventdoneupdate);
        eventtypeup=findViewById(R.id.etypeupdate);
        eventdattimeup=findViewById(R.id.etimeupdate);
        eventnameup=findViewById(R.id.enameupdate);
        noofguesup=findViewById(R.id.eguestupdate);
        contactup=findViewById(R.id.econtactupdate);
        describtionup=findViewById(R.id.edesupdate);
        openHelper=new DatabaseHelper(this);
        eventidup=findViewById(R.id.eventidupdate);

        update_btn.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                String typename =eventtypeup.getText().toString();
                String ename = eventnameup.getText().toString();
                String etime = eventdattimeup.getDayOfMonth() + "/" + eventdattimeup.getMonth() + "/" + eventdattimeup.getYear();
                String guest= noofguesup.getText().toString();
                String contactu =contactup.getText().toString();
                String edesc =describtionup.getText().toString();
                db=openHelper.getWritableDatabase();
                if(eventtypeup.length() !=0 && eventnameup.length() !=0
                        && noofguesup.length() !=0 && contactup.length() !=0 && describtionup.length() !=0) {
                    updateData(typename, ename, etime, guest, contactu, edesc);
                    Toast.makeText(getApplicationContext(), "Event UPDATED SUCCESSFULLY", Toast.LENGTH_LONG).show();
                    eventnameup.setText("");
                    eventtypeup.setText("");
                    noofguesup.setText("");
                    contactup.setText("");
                    describtionup.setText("");
                    Intent i = new Intent(UpdateEvent.this, ViewEvent.class);
                    startActivity(i);
                    finish();
                }
                else {
                    Toast.makeText(UpdateEvent.this, "", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    private boolean updateData(String typename, String ename, String etime, String guest, String contactu, String edesc) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COlS2, typename);
        contentValues.put(DatabaseHelper.COlS3, ename);
        contentValues.put(DatabaseHelper.COlS4, etime);
        contentValues.put(DatabaseHelper.COlS5, guest);
        contentValues.put(DatabaseHelper.COlS6, contactu);
        contentValues.put(DatabaseHelper.COlS7, edesc);
        String id = eventidup.getText().toString();
        return db.update(DatabaseHelper.TABLE_NAME,contentValues,DatabaseHelper.COlS1 + "=?", new String[]{id})>0;
    }
}