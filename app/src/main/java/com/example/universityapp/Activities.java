package com.example.universityapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Activities extends AppCompatActivity {

    RecyclerView rvActivities;
    DatabaseReference ref;
    ArrayList<ActivitiesModel> list = new ArrayList<>();
    ArrayList<ActivitiesModel> weeklyList = new ArrayList<>(); // list to check if activity should be displayed

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ref = FirebaseDatabase.getInstance().getReference("Activities");

        setContentView(R.layout.activity_activities);

        rvActivities = findViewById(R.id.rvActivities);
        rvActivities.setLayoutManager(new LinearLayoutManager(this));

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
                            list.add(dts.getValue(ActivitiesModel.class));
                        }
                        setWeeklyList(); //Method to filter the RecycleView list of shown elements
                                         //so the activities only get displayed on the right week.
                        ActivitiesAdapter adapter = new ActivitiesAdapter(weeklyList);
                        rvActivities.setAdapter(adapter);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }

    private void setWeeklyList() {

        weeklyList.clear();

        for(ActivitiesModel act : list) {

            Date currentDate = new Date();

            act.setCalendarDate(act.parseDate(act.getActivitiesDate()));

            Calendar currentCalendar = Calendar.getInstance(Locale.UK);
            Calendar calendar = Calendar.getInstance(Locale.UK);


            currentCalendar.setTime(currentDate);
            calendar.setTime(act.getCalendarDate());
            if( (calendar.get(Calendar.WEEK_OF_YEAR) == currentCalendar.get(Calendar.WEEK_OF_YEAR))
                    && (calendar.get(Calendar.YEAR) == currentCalendar.get(Calendar.YEAR))) {
                weeklyList.add(act);
            }
        }
    }
}
