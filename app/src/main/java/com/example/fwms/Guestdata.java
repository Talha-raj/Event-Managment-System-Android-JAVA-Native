package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Guestdata extends AppCompatActivity {
    ListView guestdatalist;
    UserDatabasehelper mDatabaseHelper;
    SQLiteDatabase dbs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guestdata);
        guestdatalist=findViewById(R.id.guestlistview);
        getSupportActionBar().hide();
        populateListView();

    }

    private void populateListView() {
        mDatabaseHelper = new UserDatabasehelper(this);
        int gre = getIntent().getIntExtra("Gre",0);
        List<String> data = mDatabaseHelper.getData(gre);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Guestdata.this, android.R.layout.simple_list_item_1, data);
        guestdatalist.setAdapter(adapter);
        guestdatalist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dbs=mDatabaseHelper.getWritableDatabase();
                String eventname = getIntent().getExtras().getString("eventname");
                String eventtype = getIntent().getExtras().getString("eventtype");
                String eventdate = getIntent().getExtras().getString("eventdate");
                String eventlocation = getIntent().getExtras().getString("eventlocation");
                String eventcontact = getIntent().getExtras().getString("eventcontact");
                String eventdesc = getIntent().getExtras().getString("eventdesc");
                String uname = data.get(position);
                updateuser(eventname,uname,eventtype,eventdate,eventlocation,eventcontact,eventdesc);
                Toast.makeText(Guestdata.this,"Invite sent to" + data.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean updateuser(String eventname, String uname,String eventtype,String eventdate,String eventlocation,String eventcontact,String eventdesct) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserDatabasehelper.COl6, eventname);
        contentValues.put(UserDatabasehelper.COl7, eventtype);
        contentValues.put(UserDatabasehelper.COl8, eventdate);
        contentValues.put(UserDatabasehelper.COl9, eventlocation);
        contentValues.put(UserDatabasehelper.COl10, eventcontact);
        contentValues.put(UserDatabasehelper.COl11, eventdesct);

        String guestname = uname;
        return dbs.update(UserDatabasehelper.TABLE_NAME,contentValues,UserDatabasehelper.COl2 + "=?", new String[]{guestname})>0;
        
    }


}