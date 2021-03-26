package com.example.universityapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Timetable extends AppCompatActivity {

    private Intent intent;
    DatabaseReference ref;
    Spinner groupChoices;
    Button btnShowTimetable;
    RecyclerView rvClasses;
    ArrayList<Classes> list = new ArrayList<>();
    ArrayList<Classes> groupList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ref = FirebaseDatabase.getInstance().getReference("Classes");
        setContentView(R.layout.activity_timetable);

        rvClasses = findViewById(R.id.rvClasses);
        rvClasses.setLayoutManager(new LinearLayoutManager(this));

        groupChoices = findViewById(R.id.groupChoices);
        btnShowTimetable = findViewById(R.id.btnShowTimetable);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        R.array.groupChoices, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        groupChoices.setAdapter(adapter);

        btnShowTimetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String group = groupChoices.getSelectedItem().toString();
                if(ref != null) {
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()) {
                                list = new ArrayList<>();
                                for(DataSnapshot dts : snapshot.getChildren()) {
                                    if(dts.getKey().toString().equals(group)) {
                                        list.add(dts.getValue(Classes.class));
                                    }

                                }
//                                setGroupList();
                                ClassesAdapter adapter = new ClassesAdapter(list);
                                rvClasses.setAdapter(adapter);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    //    private void setGroupList() {
//        String group = groupChoices.getSelectedItem().toString();
//        for(Classes cls : list) {
//            if(cls.getGroupId() == group) {
//                groupList.add(cls);
//            }
//        }
//    }

}