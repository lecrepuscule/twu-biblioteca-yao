package com.twu.biblioteca;

public class Book {
    private int id;
    private String title;
    private String author;
    private int year;
    private Boolean checkedOut = false;

    public Book(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getId() { return id; }

    public Boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(Boolean status) {
        checkedOut = status;
    }

}
