package com.example.joseph.customcontentprovider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);

    }

    public void populateDB(View view) {

        dbHelper.savePerson(new Person("joseph","24","male","12345667","address1"));
        dbHelper.savePerson(new Person("joe","24","male","12345667","address1"));
        dbHelper.savePerson(new Person("j","24","male","12345667","address1"));
        dbHelper.savePerson(new Person("jj","24","male","12345667","address1"));
        dbHelper.savePerson(new Person("jjjj","24","male","12345667","address1"));
        dbHelper.savePerson(new Person("joeee","24","male","12345667","address1"));
        dbHelper.savePerson(new Person("jose","24","male","12345667","address1"));
        dbHelper.savePerson(new Person("joseeee","24","male","12345667","address1"));
        dbHelper.savePerson(new Person("joshhh","24","male","12345667","address1"));
        dbHelper.savePerson(new Person("jaaa","24","male","12345667","address1"));

    }
}
