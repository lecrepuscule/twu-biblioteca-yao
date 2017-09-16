package com.twu.biblioteca;

public class BibliotecaApp {

    private Book[] books;

    public BibliotecaApp() {
        System.out.println("Welcome to Biblioteca");
    }

    public BibliotecaApp(Book[] bookList) {
        books = bookList;
        System.out.println("Welcome to Biblioteca");
    }

    public void printBookList() {
        for (int i = 0; i < books.length; i++) {
            System.out.println("title: " + books[i].getTitle() + "; author: " + books[i].getAuthor() + "; year: " + books[i].getYear());
        }
    }
}
