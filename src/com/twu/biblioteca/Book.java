package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private int year;
    private Boolean checkedOut = false;

    public Book(String bookTitle, String authorName, int publishedYear) {
        title = bookTitle;
        author = authorName;
        year = publishedYear;
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

    public Boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkOut() {
        checkedOut = true;
    }

    public void returnBook() {
        checkedOut = false;
    }
}
