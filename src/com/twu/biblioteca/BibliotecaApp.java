package com.twu.biblioteca;

public class BibliotecaApp {

    private String[] books;

    public BibliotecaApp() {
        System.out.println("Welcome to Biblioteca");
    }

    public BibliotecaApp(String[] bookList) {
        books = bookList;
        System.out.println("Welcome to Biblioteca");
    }

    public String[] listBooks() {
        return books;
    }
}
