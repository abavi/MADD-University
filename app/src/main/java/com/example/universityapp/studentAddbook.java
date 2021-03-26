package com.example.universityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class studentAddbook extends AppCompatActivity {

    EditText studentTitle, studentAuthor, studentDescription;
    Button studentBtn;
    DatabaseReference reff1;
    studentBooks sBooks;
    Intent intent;
    String sTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_addbook);
        intent= getIntent();
        studentTitle=findViewById(R.id.studentTitle);
        studentAuthor=findViewById(R.id.studentAuthor);
        studentDescription=findViewById(R.id.studentDescription);
        studentBtn=findViewById(R.id.studentBtn);
        sBooks=new studentBooks();
        reff1= FirebaseDatabase.getInstance().getReference("StudentBooks");
        studentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sBooks.setsTitle(studentTitle.getText().toString().trim());
                sBooks.setsAuthor(studentAuthor.getText().toString().trim());
                sBooks.setsDescription(studentDescription.getText().toString().trim());
                sTitle=(studentTitle.getText().toString().trim());
                reff1.child(sTitle).setValue(sBooks);
                Toast.makeText(studentAddbook.this, "Book Added!", Toast.LENGTH_SHORT).show();
                finish();



            }
        });

    }
}