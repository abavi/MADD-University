package com.example.universityapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class saleAdapter extends FirebaseRecyclerAdapter<booksaleModel, saleAdapter.viewholder1> {

    public saleAdapter(@NonNull FirebaseRecyclerOptions<booksaleModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewholder1 holder, int position, @NonNull booksaleModel model) {

     holder.Title.setText(model.getsTitle());
     holder.Author.setText(model.getsAuthor());
     holder.Description.setText(model.getsDescription());


    }

    @NonNull
    @Override
    public viewholder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_s,parent,false);
        return new viewholder1(view1);
    }

    class viewholder1 extends RecyclerView.ViewHolder
    {
        TextView Title, Author, Description;
        public viewholder1(@NonNull View itemView) {

            super(itemView);
            Title=(TextView)itemView.findViewById(R.id.sTitle);
            Author=(TextView)itemView.findViewById(R.id.sAuthro);
            Description=(TextView)itemView.findViewById(R.id.sDescription);
        }
    }
}
