package com.example.universityapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ClassesAdapter extends RecyclerView.Adapter<ClassesAdapter.classesViewholder> {

    ArrayList<Classes> list;
    public ClassesAdapter(ArrayList<Classes> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public classesViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_classes, parent, false);
        return new classesViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull classesViewholder holder, int position) {
        holder.groupId.setText(list.get(position).getGroupId());
        holder.classesTime.setText(list.get(position).getTime());
        holder.classesDate.setText(list.get(position).getDate());
        holder.moduleName.setText(list.get(position).getModuleName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class classesViewholder extends RecyclerView.ViewHolder {
        TextView groupId, classesTime, classesDate, moduleName;

        public classesViewholder(@NonNull View itemView) {
            super(itemView);
            groupId = itemView.findViewById(R.id.txtGroupId);
            classesTime = itemView.findViewById(R.id.txtClassTime);
            classesDate = itemView.findViewById(R.id.txtClassDate);
            moduleName = itemView.findViewById(R.id.txtModuleName);
        }
    }
}
