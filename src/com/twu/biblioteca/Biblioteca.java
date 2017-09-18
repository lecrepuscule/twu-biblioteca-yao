package com.twu.biblioteca;

public class Biblioteca {

    private Book[] books;

    public Biblioteca() {
        Book book1 = new Book(1,"book1", "author1", 2000);
        Book book2 = new Book(2,"book2", "author2", 2001);
        Book book3 = new Book(3,"book3", "author3", 2002);
        Book book4 = new Book(4,"book4", "author4", 2003);

        books = new Book[] {book1, book2, book3, book4};
    }

    public Biblioteca(Book[] bookList) {
        books = bookList;
    }

//    public void checkoutBook(Book book) {
//        if ()
//        book.setCheckedOut(true);
//    }


    public void printBookList() {
        for (int i = 0; i < books.length; i++) {
            if (!books[i].isCheckedOut()) {
                System.out.println("id: " + books[i].getId() + "title: " + books[i].getTitle() + "; author: " + books[i].getAuthor() + "; year: " + books[i].getYear());
            }
        }
    }
}
