package com.example.universityapp;

public class booksaleModel {

    String sTitle, sAuthor, sDescription;

    booksaleModel(){

    }

    public booksaleModel(String sTitle, String sAuthor, String sDescription) {
        this.sTitle = sTitle;
        this.sAuthor = sAuthor;
        this.sDescription = sDescription;
    }

    public String getsTitle() {
        return sTitle;
    }

    public void setsTitle(String sTitle) {
        this.sTitle = sTitle;
    }

    public String getsAuthor() {
        return sAuthor;
    }

    public void setsAuthor(String sAuthor) {
        this.sAuthor = sAuthor;
    }

    public String getsDescription() {
        return sDescription;
    }

    public void setsDescription(String sDescription) {
        this.sDescription = sDescription;
    }
}
