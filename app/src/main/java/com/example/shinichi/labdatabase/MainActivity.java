package com.example.shinichi.labdatabase;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button) findViewById(R.id.button);
        rv = (RecyclerView) findViewById(R.id.rv);
        Student neil = new Student("Neil Capistrano","Tunasan, Muntinlupa City","Sept 30, 1997");
        DatabaseHelper db = new DatabaseHelper(getBaseContext());
        db.addStudent(neil);
        // create layout
        // create layout each item
        //create adapater
        //link adpater to recyclerview
        Cursor c = new DatabaseHelper(getBaseContext()).getAllStudents();
        StudentAdapter sa = new StudentAdapter(getBaseContext(),c);
        rv.setAdapter(sa);
        rv.setLayoutManager(new LinearLayoutManager(getBaseContext(),LinearLayoutManager.VERTICAL,false));

    }
}
