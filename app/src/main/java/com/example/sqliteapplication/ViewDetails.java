package com.example.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewDetails extends AppCompatActivity {

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        ListView listView =(ListView) findViewById(R.id.listview);
        DB = new DBHelper(this);

        ArrayList<String> list = new ArrayList<>();
        Cursor cursor = DB.getdata();


        if(cursor.getCount() == 0){
            Toast.makeText(ViewDetails.this, "Nothing existed!", Toast.LENGTH_SHORT).show();

        }else{
            while (cursor.moveToNext()) {
                list.add("Name: "+cursor.getString(0)+"\n"+"Phone"+cursor.getString(1)+"\n"+"Date of Birth:" +cursor.getString(2));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
                listView.setAdapter(listAdapter);
            }
        }
    }
}