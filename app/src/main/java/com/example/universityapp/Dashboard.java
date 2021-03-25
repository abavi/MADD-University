package com.example.universityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    TextView txtStudentId;
    private Intent intent;
    String studentID;
    Button btnLibrary, btnMoodle, btnTimetable, btnFloorMap, btnBooksale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        txtStudentId = findViewById(R.id.txtStudentId);
        intent = getIntent();
        btnLibrary = findViewById(R.id.btnLibrary);
        btnMoodle = findViewById(R.id.btnMoodle);
        btnFloorMap = findViewById(R.id.btnFloorMap);
        btnBooksale =findViewById(R.id.btnBooksale);

        if(intent.getSerializableExtra(MainActivity.STUDENTID) != null) {
            studentID = (String) intent.getSerializableExtra(MainActivity.STUDENTID);
            txtStudentId.setText(studentID);
        }

        //Send to library
        btnLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),Library.class);
                startActivity(intent);

            }
        });

        //Open browser for Moodle webpage
        btnMoodle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://moodle.roehampton.ac.uk/login/index.php")));
            }
        });

        //Show a list with all areas of interest on the Floor Map
        btnFloorMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FloorMapIndex.class));
            }
        });

        btnBooksale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Booksale.class));
            }
        });
    }
}