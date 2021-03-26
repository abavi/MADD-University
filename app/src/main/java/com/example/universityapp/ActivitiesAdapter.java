package com.example.universityapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.activitiesViewholder> {
    ArrayList<ActivitiesModel> list;
    public ActivitiesAdapter(ArrayList<ActivitiesModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public activitiesViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_activities, parent, false);
        return new activitiesViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull activitiesViewholder holder, int position) {
        holder.activitiesTitle.setText(list.get(position).getActivitiesTitle());
        holder.activitiesDesc.setText(list.get(position).getActivitiesDesc());
        holder.activitiesDate.setText(list.get(position).getActivitiesDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class activitiesViewholder extends RecyclerView.ViewHolder {
        TextView activitiesTitle, activitiesDesc, activitiesDate;
        public activitiesViewholder(@NonNull View itemView) {
            super(itemView);
            activitiesTitle = itemView.findViewById(R.id.txtActivityTitle);
            activitiesDesc = itemView.findViewById(R.id.txtActivityDescription);
            activitiesDate = itemView.findViewById(R.id.txtActivityDate);
        }
    }

}

