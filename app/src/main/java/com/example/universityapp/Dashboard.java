package com.example.universityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    TextView txtStudentId;
    private Intent intent;
    String studentID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        txtStudentId = findViewById(R.id.txtStudentId);
        intent = getIntent();

        if(intent.getSerializableExtra(MainActivity.STUDENTID) != null) {
            studentID = (String) intent.getSerializableExtra(MainActivity.STUDENTID);
            txtStudentId.setText(studentID);
        }
    }
}