package com.example.universityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FloorMapIndex extends AppCompatActivity {

    TextView txtComputerLab, txtDisabledStudentService, txtFoodCourt
            , txtInfoDesk, txtLab, txtLounge, txtPostOffice, txtRoom101
            , txtRoom102, txtRoom103, txtRoom104, txtRoom105, txtRoom106
            , txtRoom107, txtStaffOffices, txtStudentFinance, txtStudentOrganizations
            , txtStudentServices, txtStudentWellbeing, txtToilets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_map_index);

        txtComputerLab = findViewById(R.id.txtComputerLab);
        txtDisabledStudentService = findViewById(R.id.txtDisabledStudentService);
        txtFoodCourt = findViewById(R.id.txtFoodCourt);
        txtInfoDesk = findViewById(R.id.txtInfoDesk);
        txtLab = findViewById(R.id.txtLab);
        txtLounge = findViewById(R.id.txtLounge);
        txtPostOffice = findViewById(R.id.txtPostOffice);
        txtRoom101 = findViewById(R.id.txtRoom101);
        txtRoom102 = findViewById(R.id.txtRoom102);
        txtRoom103 = findViewById(R.id.txtRoom103);
        txtRoom104 = findViewById(R.id.txtRoom104);
        txtRoom105 = findViewById(R.id.txtRoom105);
        txtRoom106 = findViewById(R.id.txtRoom106);
        txtRoom107 = findViewById(R.id.txtRoom107);
        txtStaffOffices = findViewById(R.id.txtStaffOffices);
        txtStudentFinance = findViewById(R.id.txtStudentFinance);
        txtStudentOrganizations = findViewById(R.id.txtStudentOrganizations);
        txtStudentServices = findViewById(R.id.txtStudentServices);
        txtStudentWellbeing = findViewById(R.id.txtStudentWellbeing);
        txtToilets = findViewById(R.id.txtToilet);

        //Make the room names clickable. The user is shown the floor that the room is in.

        txtComputerLab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Floor1.class));
            }
        });

        txtDisabledStudentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Floor1.class));
            }
        });

        txtFoodCourt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Floor1.class));
            }
        });

        txtInfoDesk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Floor1.class));
            }
        });

        txtLab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Floor1.class));
            }
        });

        txtLounge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Floor2.class));
            }
        });

        txtPostOffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Floor1.class));
            }
        });

        txtRoom101.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Floor2.class));
            }
        });

        txtRoom102.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Floor2.class));
            }
        });

        txtRoom103.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Floor2.class));
            }
        });

        txtRoom104.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Floor2.class));
            }
        });

        txtRoom105.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Floor2.class));
            }
        });

        txtRoom106.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Floor2.class));
            }
        });

        txtRoom107.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Floor2.class));
            }
        });

        txtStaffOffices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Floor1.class));
            }
        });

        txtStudentFinance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Floor1.class));
            }
        });

        txtStudentOrganizations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Floor1.class));
            }
        });

        txtStudentServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Floor1.class));
            }
        });

        txtStudentWellbeing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Floor1.class));
            }
        });

        txtToilets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Floor1.class));
            }
        });

    }
}