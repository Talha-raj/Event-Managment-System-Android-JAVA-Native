package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteEvent extends AppCompatActivity {
Button btn_delete;
EditText text_getid;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_event);
        text_getid=findViewById(R.id.btn_txtid);
        btn_delete=findViewById(R.id.btn_delte);
        openHelper=new DatabaseHelper(this);
     btn_delete.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             db=openHelper.getWritableDatabase();
             String id = text_getid.getText().toString();
             deleteData(id);
             Toast.makeText(getApplicationContext(), "Event Deleted successfully", Toast.LENGTH_LONG).show();
             text_getid.setText("");
             Intent i = new Intent(DeleteEvent.this,ViewEvent.class);
             startActivity(i);
         }
     });

    }
    public boolean deleteData(String id){
        return db.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.COlS1 + "=?", new String[]{id})>0;
    }
}