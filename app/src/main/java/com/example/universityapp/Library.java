package com.example.universityapp;

import android.os.Bundle;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Library extends AppCompatActivity {

    RecyclerView library;
    DatabaseReference ref;
    ArrayList<LibraryModel> list = new ArrayList<>();
    SearchView searchview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ref = FirebaseDatabase.getInstance().getReference("Books");

        setContentView(R.layout.activity_library);

        library = findViewById(R.id.library);
        library.setLayoutManager(new LinearLayoutManager(this));
        searchview = findViewById(R.id.search);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(ref != null) {
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()) {
                        list = new ArrayList<>();
                        for(DataSnapshot dts : snapshot.getChildren()) {
                            list.add(dts.getValue(LibraryModel.class));
                        }
//                        LibraryAdapter adapter = new LibraryAdapter(list);
//                        library.setAdapter(adapter);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        if(searchview != null){
            searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    search(newText);
                    return true;
                }
            });
        }
    }
    private void search(String str){

        ArrayList<LibraryModel> myList = new ArrayList<>();
        for(LibraryModel object : list){

            if(object.getSubject().toLowerCase().contains(str.toLowerCase()))
            {
                myList.add(object);
            }

        }
        LibraryAdapter LibrabryAdapter = new LibraryAdapter(myList);
        library.setAdapter(LibrabryAdapter);


    }
}
