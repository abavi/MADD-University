package com.example.universityapp;

public class Books {
    String Title;
    String Author;
    Integer Edition;
    String Subject;
    String ISBN;

    public Books() {

    }

    @Override
    public String toString() {
        return "Books{" +
                "Title='" + Title + '\'' +
                ", Author='" + Author + '\'' +
                ", Edition=" + Edition +
                ", Subject='" + Subject + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
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

    public Integer getEdition() {
        return Edition;
    }

    public void setEdition(Integer edition) {
        Edition = edition;
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
}
