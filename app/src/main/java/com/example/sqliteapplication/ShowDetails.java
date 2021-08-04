package com.example.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowDetails extends AppCompatActivity {

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        ListView listView =(ListView) findViewById(R.id.listview);
        DB = new DBHelper(this);

        ArrayList<String> arrayList = new ArrayList<>();
        Cursor cursor = DB.getdata();

            while (cursor.moveToNext()) {
                arrayList.add("Name: "+cursor.getString(0));
                arrayList.add("Contact: "+cursor.getString(1));
                arrayList.add("DOB: "+cursor.getString(2));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
                listView.setAdapter(listAdapter);

            }
    }
}