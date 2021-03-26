package com.example.universityapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ActivitiesAdapter extends FirebaseRecyclerAdapter<ActivitiesModel, ActivitiesAdapter.viewholder> {

    public ActivitiesAdapter(@NonNull FirebaseRecyclerOptions<ActivitiesModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewholder holder, int position, @NonNull ActivitiesModel model) {
        holder.Title.setText(model.getActivitiesTitle());
        holder.Description.setText(model.getActivitiesDesc());
        holder.ActivityDate.setText(model.getActivitiesDate());
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_activities, parent, false);
        return new ActivitiesAdapter.viewholder(view);
    }

    class viewholder extends ViewHolder {

        TextView Title, Description, ActivityDate;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            Title = (TextView)itemView.findViewById(R.id.txtActivityTitle);
            Description = (TextView)itemView.findViewById(R.id.txtActivityDescription);
            ActivityDate = (TextView)itemView.findViewById(R.id.txtActivityDate);
        }
    }
}
