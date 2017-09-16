package com.twu.biblioteca;

public class Biblioteca {

    private Book[] books;
    private Boolean run = true;

    public Biblioteca() {
        System.out.println("Welcome to Biblioteca");
        Book book1 = new Book("book1", "author1", 2000);
        Book book2 = new Book("book2", "author2", 2001);
        Book book3 = new Book("book3", "author3", 2002);
        Book book4 = new Book("book4", "author4", 2003);

        books = new Book[] {book1, book2, book3, book4};
    }

    public Biblioteca(Book[] bookList) {
        books = bookList;
        System.out.println("Welcome to Biblioteca");
    }


    public void printBookList() {
        for (int i = 0; i < books.length; i++) {
            System.out.println("title: " + books[i].getTitle() + "; author: " + books[i].getAuthor() + "; year: " + books[i].getYear());
        }
    }
}
