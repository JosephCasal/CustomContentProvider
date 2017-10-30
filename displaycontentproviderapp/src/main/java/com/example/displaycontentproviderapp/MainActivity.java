package com.example.displaycontentproviderapp;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";
    private List<Person> persons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");

        getPersons();

        RecyclerView rvPersons = findViewById(R.id.rvPersons);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        PersonListAdapter personListAdapter = new PersonListAdapter(persons);
        rvPersons.setLayoutManager(layoutManager);
        rvPersons.setAdapter(personListAdapter);

    }

    public void getPersons() {
        Log.d(TAG, "getPersons: ");

        Uri uri = Uri.parse("content://com.example.joseph.customcontentprovider.PROVIDER");

        grantUriPermission("com.example.joseph.customcontentprovider.MY_PERMISSION", uri, 0);
        ContentResolver resolver =  getContentResolver();
        Cursor cursor = resolver.query(uri, null, null, null, null);

        while(cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("Name"));
            String age = cursor.getString(cursor.getColumnIndex("Age"));
            String gender = cursor.getString(cursor.getColumnIndex("Gender"));
            String phone =  cursor.getString(cursor.getColumnIndex("Phone"));
            String address = cursor.getString(cursor.getColumnIndex("Address"));

            Log.d(TAG, "getPersons: adding " + name);

            persons.add(new Person(name, age, gender, phone, address));
        }


    }

}
