package com.example.universityapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Booksale extends AppCompatActivity {

    RecyclerView bookView;
    saleAdapter adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booksale);

        bookView=(RecyclerView)findViewById(R.id.booksale);
        bookView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<booksaleModel> options =
                new FirebaseRecyclerOptions.Builder<booksaleModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("StudentBooks"), booksaleModel.class)
                        .build();
        adapter1= new saleAdapter(options);
        bookView.setAdapter(adapter1);




    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter1.startListening();

    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter1.stopListening();
    }
}