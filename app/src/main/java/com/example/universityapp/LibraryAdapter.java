package com.example.universityapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.libraryViewholder> {
    ArrayList<LibraryModel> list;
    public LibraryAdapter(ArrayList<LibraryModel> list){
        this.list = list;
    }

    @NonNull
    @Override
    public libraryViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent, false);
        return new libraryViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull libraryViewholder holder, int position) {

        holder.author.setText(list.get(position).getAuthor());
        holder.edition.setText(list.get(position).getEdition().toString());
        holder.isbn.setText(list.get(position).getISBN());
        holder.subject.setText(list.get(position).getSubject());
        holder.title.setText(list.get(position).getSubject());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class libraryViewholder extends RecyclerView.ViewHolder {
        TextView author,edition,isbn,subject,title;
        public libraryViewholder(@NonNull View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.bookAuthor);
            edition = itemView.findViewById(R.id.bookEdition);
            isbn = itemView.findViewById(R.id.bookISBN);
            subject = itemView.findViewById(R.id.bookSubject);
            title = itemView.findViewById(R.id.bookTitle);


        }
    }

}
