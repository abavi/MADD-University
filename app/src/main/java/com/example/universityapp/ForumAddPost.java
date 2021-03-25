package com.example.universityapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class ForumAddPost extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;
    private EditText etPostTitle, etPostDescription;
    private Button btnPublishPost;
    String studentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_add_post);

        etPostTitle = findViewById(R.id.etPostTitle);
        etPostDescription = findViewById(R.id.etPostDescription);
        btnPublishPost = findViewById(R.id.btnPublishPost);
        btnPublishPost.setOnClickListener(this);

        intent = getIntent();
        if(intent.getSerializableExtra(MainActivity.STUDENTID) != null) {
            studentId = (String) intent.getSerializableExtra(MainActivity.STUDENTID);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPublishPost:
                publishPost();
                break;
        }
    }

    private void publishPost() {
        String postTitle = etPostTitle.getText().toString().trim();
        String postDesc = etPostDescription.getText().toString().trim();

        if(postTitle.isEmpty()) {
            etPostTitle.setError("Post title required!");
            etPostTitle.requestFocus();
            return;
        }

        if(postDesc.isEmpty()) {
            etPostDescription.setError("Post description required!");
            etPostTitle.requestFocus();
            return;
        }

        ForumPost forumPost = new ForumPost(postTitle,postDesc, studentId);
        FirebaseDatabase.getInstance().getReference("ForumPosts")
                .child(postTitle)
                .setValue(forumPost).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(ForumAddPost.this, "Post published!", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }
}