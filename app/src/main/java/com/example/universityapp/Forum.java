package com.example.universityapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.universityapp.MainActivity.STUDENTID;

public class Forum extends AppCompatActivity {

    private Intent intent;
    TextView txtStudentIdForum;
    String studentID;
    RecyclerView rvForumPosts;
    ForumAdapter adapter;
    Button btnAddPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        btnAddPost = findViewById(R.id.btnAddPost);

        btnAddPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), ForumAddPost.class);
                intent.putExtra(STUDENTID, studentID);
                startActivity(intent);
            }
        });


        rvForumPosts = findViewById(R.id.rvForumPosts);
        rvForumPosts.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<ForumModel> options =
                new FirebaseRecyclerOptions.Builder<ForumModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("ForumPosts"), ForumModel.class)
                        .build();

        adapter = new ForumAdapter(options);
        rvForumPosts.setAdapter(adapter);

        txtStudentIdForum = findViewById(R.id.txtStudentIdForum);
        intent = getIntent();

        if(intent.getSerializableExtra(MainActivity.STUDENTID) != null) {
            studentID = (String) intent.getSerializableExtra(MainActivity.STUDENTID);
            txtStudentIdForum.setText(studentID);
        }
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