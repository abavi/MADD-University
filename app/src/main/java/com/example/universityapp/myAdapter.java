package com.example.universityapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myAdapter extends FirebaseRecyclerAdapter<LibraryModel, myAdapter.viewholder> {

    public myAdapter(@NonNull FirebaseRecyclerOptions<LibraryModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewholder holder, int position, @NonNull LibraryModel model) {

        holder.title.setText(model.getTitle());
        holder.author.setText(model.getAuthor());
        holder.edition.setText(model.getEdition().toString());
        holder.subject.setText(model.getSubject());
        holder.isbn.setText(model.getISBN());

    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new viewholder(view);
    }

    class viewholder extends RecyclerView.ViewHolder
    {
        TextView title,author,edition,subject,isbn;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.bookTitle);
            author=(TextView)itemView.findViewById(R.id.bookAuthor);
            edition=(TextView)itemView.findViewById(R.id.bookEdition);
            subject=(TextView)itemView.findViewById(R.id.bookSubject);
            isbn=(TextView)itemView.findViewById(R.id.bookISBN);

        }
    }

}
