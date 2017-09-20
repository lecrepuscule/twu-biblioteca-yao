package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class Biblioteca {

    private Map<Integer, Book> books = new HashMap<Integer, Book>();

    public Biblioteca() {
        Book book1 = new Book(1,"book1", "author1", 2000);
        Book book2 = new Book(2,"book2", "author2", 2001);
        Book book3 = new Book(3,"book3", "author3", 2002);
        Book book4 = new Book(4,"book4", "author4", 2003);
        Book book5 = new Book(5,"book5", "author5", 2004);
        book5.setCheckedOut(true);


        books.put(1, book1);
        books.put(2, book2);
        books.put(3, book3);
        books.put(4, book4);
        books.put(5, book5);

    }

    public int checkoutBook(int bookId) {
        if (canCheckoutBook(bookId)) {
            books.get(bookId).setCheckedOut(true);
            return bookId;
        }
        return 0;
    }

    public int returnBook(int bookId) {
        if (canReturnBook(bookId)) {
            books.get(bookId).setCheckedOut(false);
            return bookId;
        }
        return 0;
    }

    public Boolean canCheckoutBook(int bookId) {
        return books.containsKey(bookId) && !books.get(bookId).isCheckedOut();
    }

    public Boolean canReturnBook(int bookId) {
        return books.containsKey(bookId) && books.get(bookId).isCheckedOut();
    }

    public void printBookList() {
        for (Book book : books.values()) {
            if (!book.isCheckedOut()) {
                System.out.println("id: " + book.getId() + "; title: " + book.getTitle() + "; author: " + book.getAuthor() + "; year: " + book.getYear());
            }
        }
    }

    public void printReturnBookList() {
        for (Book book : books.values()) {
            if (book.isCheckedOut()) {
                System.out.println("id: " + book.getId() + "; title: " + book.getTitle() + "; author: " + book.getAuthor() + "; year: " + book.getYear());
            }
        }
    }
}
