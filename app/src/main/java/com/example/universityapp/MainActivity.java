package com.example.universityapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText etLoginStudentID, etLoginPassword;
    Button btnLogin;
    TextView txtRegister;

    public static final String STUDENTID = "studentkey"; // Allows the StudentID to be passed between activities

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRegister = (TextView) findViewById(R.id.txtRegister);

        btnLogin = (Button) findViewById(R.id.btnLogIn);
        etLoginStudentID = (EditText) findViewById(R.id.etLoginStudentID);
        etLoginPassword = (EditText) findViewById(R.id.etLoginPassword);

        mAuth = FirebaseAuth.getInstance();


        // Send to Register User activity
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RegisterUser.class);
                startActivity(intent);
            }
        });

        //Login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });
    }
    private void userLogin() {
        String studentID = etLoginStudentID.getText().toString().trim();
        String password = etLoginPassword.getText().toString().trim();

        if(studentID.isEmpty()) {
            etLoginStudentID.setError("Username required!");
            etLoginStudentID.requestFocus();
            return;
        }

        if(password.isEmpty()) {
            etLoginPassword.setError("Password required!");
            etLoginPassword.requestFocus();
            return;
        }

        FirebaseDatabase.getInstance().getReference("Users")
                .child(studentID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.getValue() == null) { // Check if username already exists
                    Toast.makeText(MainActivity.this, "Username not registered!", Toast.LENGTH_LONG).show();
                }
                else {
                    // Check password
                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(studentID).child("password").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.getValue().toString().equals(password)) { // Go to Dashboard
                                Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                                intent.putExtra(STUDENTID, studentID);
                                startActivity(intent);
                                finish();
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Wrong password!", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}