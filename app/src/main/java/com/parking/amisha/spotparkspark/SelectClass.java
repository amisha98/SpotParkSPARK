package com.parking.amisha.spotparkspark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectClass extends AppCompatActivity {

    Button student, faculty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_class);

        student = (Button) findViewById(R.id.student);
        faculty = (Button) findViewById(R.id.faculty);

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(SelectClass.this, StudentActivity.class);
                startActivity(in);
            }
        });

        faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(SelectClass.this, FacultyActivity.class);
                startActivity(in);
            }
        });
    }
}
