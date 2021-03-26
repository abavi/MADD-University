package com.example.universityapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Activities extends AppCompatActivity {

    RecyclerView rvActivities;
    ActivitiesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);

        rvActivities = findViewById(R.id.rvActivities);
        rvActivities.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<ActivitiesModel> options =
                new FirebaseRecyclerOptions.Builder<ActivitiesModel>()
                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Activities"), ActivitiesModel.class)
                    .build();

        adapter = new ActivitiesAdapter(options);
        rvActivities.setAdapter(adapter);

        ActivitiesModel activitate = new ActivitiesModel("Chess", "Chess club", "22-03-2021");
        activitate.setCalendarDate(activitate.parseDate(activitate.getActivitiesDate()));
        //Toast.makeText(Activities.this, activitate.toString() , Toast.LENGTH_LONG).show();
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.setTime(activitate.getCalendarDate());
        int dayOfWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        Date date = calendar.getTime();
        Toast.makeText(Activities.this, String.valueOf(dayOfWeek) , Toast.LENGTH_LONG).show();
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