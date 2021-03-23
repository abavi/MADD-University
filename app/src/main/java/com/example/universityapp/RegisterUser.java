package com.example.universityapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {

    private TextView etFirstName, etLastName, etEmail, etPassword, etRegisterStudentID;
    private Button btnRegister;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();

        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);

        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etRegisterStudentID = (EditText) findViewById(R.id.etRegisterStudentID);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegister:
                registerUser();
                break;
        }
    }

    private void registerUser() {
        String email = etEmail.getText().toString().trim();
        String firstName = etFirstName.getText().toString().trim();
        String lastName = etLastName.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String studentID = etRegisterStudentID.getText().toString().trim();

        if(firstName.isEmpty()) {
            etFirstName.setError("First Name Required!");
            etFirstName.requestFocus();
            return;
        }
        if(lastName.isEmpty()) {
            etLastName.setError("Last Name Required!");
            etLastName.requestFocus();
            return;
        }
        if(email.isEmpty()) {
            etEmail.setError("Email Required!");
            etEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etEmail.setError("Provide valid email address!");
            etEmail.requestFocus();
            return;
        }
        if(password.isEmpty()) {
            etPassword.setError("Password Required!");
            etPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            etPassword.setError("Password length should be more than 5 characters!");
            etPassword.requestFocus();
            return;
        }

        if (studentID.isEmpty()) {
            etRegisterStudentID.setError("Provide a valid student id!");
            etRegisterStudentID.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password).
                addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(firstName, lastName, email, studentID);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(RegisterUser.this, "User registered!", Toast.LENGTH_LONG).show();
                                        finish();
                                    }
                                    else {
                                        Toast.makeText(RegisterUser.this, "User register failed!", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        }
                        else {
                            Toast.makeText(RegisterUser.this, "User register failed!", Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
}