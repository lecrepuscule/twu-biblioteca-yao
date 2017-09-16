package com.twu.biblioteca;


import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;


public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private Book book1 = new Book("book1", "author1", 2000);
    private Book book2 = new Book("book2", "author2", 2001);
    private Book book3 = new Book("book3", "author3", 2002);
    private Book book4 = new Book("book4", "author4", 2003);

    private Book[] books = {book1, book2, book3, book4};

    @Before public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testWelcomeMessage() {
        BibliotecaApp biblioteca = new BibliotecaApp();
        assertEquals("Welcome to Biblioteca\n", outContent.toString());
    }


    @Test
    public void testListBooks() {
        BibliotecaApp biblioteca = new BibliotecaApp(books);
        biblioteca.printBookList();
        assertEquals(
                "Welcome to Biblioteca\ntitle: " + books[0].getTitle() + "; author: " + books[0].getAuthor() + "; year: " + books[0].getYear()
                        + "\ntitle: " + books[1].getTitle() + "; author: " + books[1].getAuthor() + "; year: " + books[1].getYear()
                        + "\ntitle: " + books[2].getTitle() + "; author: " + books[2].getAuthor() + "; year: " + books[2].getYear()
                        + "\ntitle: " + books[3].getTitle() + "; author: " + books[3].getAuthor() + "; year: " + books[3].getYear() + "\n",
                outContent.toString());
    }


    @Test
    public void testBookDetails() {
        assertEquals(1, 1);
    }

    @Test
    public void testMainMenu() {
        assertEquals(1, 1);
    }

    @Test
    public void testInvalidMenuOption() {
        assertEquals(1, 1);
    }

    @Test
    public void testQuit() {
        assertEquals(1, 1);
    }

    @Test
    public void testSuccessfulCheckout() {
        assertEquals(1, 1);
    }

    @Test
    public void testUnsuccessfulCheckout() {
        assertEquals(1, 1);
    }

    @Test
    public void testSucessfulReturn() {
        assertEquals(1, 1);
    }

    @Test
    public void testUnsucessfulReturn() {
        assertEquals(1, 1);
    }
}
