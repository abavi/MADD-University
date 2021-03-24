package com.example.universityapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Library extends AppCompatActivity {


    RecyclerView library;
    myAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        library=(RecyclerView)findViewById(R.id.library);
        library.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<LibraryModel> options =
                new FirebaseRecyclerOptions.Builder<LibraryModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Books"), LibraryModel.class)
                        .build();

        adapter = new myAdapter(options);
        library.setAdapter(adapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}