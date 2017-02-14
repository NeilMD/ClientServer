package com.example.shinichi.labdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ViewStudent extends AppCompatActivity {
    TextView id,name,bday, add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);

        id = (TextView) findViewById(R.id.et_id);
        name = (TextView) findViewById(R.id.et_name);
        bday = (TextView) findViewById(R.id.et_bday);
        add = (TextView) findViewById(R.id.et_add);
    }
}
