package com.example.universityapp;

public class LibraryModel {

    String Title,Author,Subject,ISBN;
    Integer Edition;

    LibraryModel(){

    }

    public LibraryModel(String title, String author, String subject, String ISBN) {
        Title = title;
        Author = author;
        Subject = subject;
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "LibraryModel{" +
                "Title='" + Title + '\'' +
                ", Author='" + Author + '\'' +
                ", Subject='" + Subject + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", Edition=" + Edition +
                '}';
    }

    public LibraryModel(String title, String author, String subject, String ISBN, Integer edition) {
        Title = title;
        Author = author;
        Subject = subject;
        this.ISBN = ISBN;
        Edition = edition;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getEdition() {
        return Edition;
    }

    public void setEdition(Integer edition) {
        Edition = edition;
    }
}
