package com.example.universityapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ForumAdapter extends FirebaseRecyclerAdapter<ForumModel, ForumAdapter.viewholder> {

    public ForumAdapter(@NonNull FirebaseRecyclerOptions<ForumModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewholder holder, int position, @NonNull ForumModel model) {
        holder.Title.setText(model.getPostTitle());
        holder.Description.setText(model.getPostDescription());
        holder.PostedBy.setText(model.getPostedBy());
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_forum, parent, false);
        return new ForumAdapter.viewholder(view);
    }

    class viewholder extends ViewHolder
    {
        TextView Title, Description, PostedBy;
        public viewholder(@NonNull View itemView) {

            super(itemView);
            Title = (TextView)itemView.findViewById(R.id.txtPostTitle);
            Description = (TextView)itemView.findViewById(R.id.txtPostDesc);
            PostedBy = (TextView)itemView.findViewById(R.id.txtPostAuthor);
        }
    }

}



