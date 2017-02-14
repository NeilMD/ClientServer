package com.example.shinichi.labdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddStudent extends AppCompatActivity {
    Button b;
    EditText name,bday,add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        b = (Button) findViewById(R.id.submit);
        name = (EditText) findViewById(R.id.et_name);
        bday = (EditText) findViewById(R.id.et_bday);
        add = (EditText) findViewById(R.id.et_add);

    }
}
