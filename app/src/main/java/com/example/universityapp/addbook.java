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

public class addbook extends AppCompatActivity {

    EditText etTitle, etAuthor, etEdition, etSubject, etISBN;
    Button btnAdd;
    DatabaseReference reff;
    Books books;
    Intent intent;
    String ISBM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbook);
        intent= getIntent();
        etTitle=findViewById(R.id.etTitle);
        etAuthor=findViewById(R.id.etAuthor);
        etEdition=findViewById(R.id.etEdition);
        etSubject=findViewById(R.id.etSubject);
        etISBN=findViewById(R.id.etISBN);
        btnAdd=findViewById(R.id.btnAdd);
        books=new Books();
        reff= FirebaseDatabase.getInstance().getReference("Books");
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edition=Integer.parseInt(etEdition.getText().toString().trim());
                  books.setTitle(etTitle.getText().toString().trim());
                books.setAuthor(etAuthor.getText().toString().trim());
                books.setEdition(edition);
                books.setSubject(etSubject.getText().toString().trim());
                 books.setISBN(etISBN.getText().toString().trim());
                  ISBM=(etISBN.getText().toString().trim());
                Toast.makeText(addbook.this, books.getTitle(), Toast.LENGTH_LONG).show();
                reff.child(ISBM).setValue(books);



            }
        });

    }
}