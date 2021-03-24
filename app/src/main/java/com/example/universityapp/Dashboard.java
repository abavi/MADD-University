package com.example.universityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    TextView txtStudentId;
    private Intent intent;
    String studentID;
    Button btnBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        txtStudentId = findViewById(R.id.txtStudentId);
        intent = getIntent();
        btnBooks = findViewById(R.id.btnBooks);

        if(intent.getSerializableExtra(MainActivity.STUDENTID) != null) {
            studentID = (String) intent.getSerializableExtra(MainActivity.STUDENTID);
            txtStudentId.setText(studentID);
        }
        btnBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getApplicationContext(),Library.class);
                startActivity(intent);

            }
        });
    }
}