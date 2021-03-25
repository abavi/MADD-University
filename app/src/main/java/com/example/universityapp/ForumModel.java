package com.example.universityapp;

public class ForumModel {

    String postTitle, postDescription, postedBy;

    public ForumModel(String postTitle, String postDescription, String postedBy) {
        this.postTitle = postTitle;
        this.postDescription = postDescription;
        this.postedBy = postedBy;
    }

    public ForumModel() {
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }
}
