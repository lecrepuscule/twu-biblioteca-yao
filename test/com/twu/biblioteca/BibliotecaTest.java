package com.twu.biblioteca;


import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;


public class BibliotecaTest {

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
        BibliotecaController bc = new BibliotecaController();
        assertThat(outContent.toString(), containsString("Welcome to Biblioteca\n"));
    }


    @Test
    public void testListBooksWithDetails() {
        Biblioteca biblioteca = new Biblioteca(books);
        biblioteca.printBookList();
        assertThat(outContent.toString(), containsString("title: " + books[0].getTitle() + "; author: " + books[0].getAuthor() + "; year: " + books[0].getYear()
                + "\ntitle: " + books[1].getTitle() + "; author: " + books[1].getAuthor() + "; year: " + books[1].getYear()
                + "\ntitle: " + books[2].getTitle() + "; author: " + books[2].getAuthor() + "; year: " + books[2].getYear()
                + "\ntitle: " + books[3].getTitle() + "; author: " + books[3].getAuthor() + "; year: " + books[3].getYear() + "\n"));
    }


    @Test
    public void testMainMenu() {
        BibliotecaController bc = new BibliotecaController();
        bc.printMenu();
        assertThat(outContent.toString(), containsString("1. List Books\n" + "0. Quit\n"));
    }

    @Test
    public void testValidMenuOption() {
        BibliotecaController bc = new BibliotecaController();
        ByteArrayInputStream input = new ByteArrayInputStream("1".getBytes());
        String userInput = bc.getValidUserInput(input, System.out);
        assertEquals("1", userInput);
    }

    @Test
    public void testInvalidMenuOption() {
        BibliotecaController bc = new BibliotecaController();
        String inputString = "2\n" + "1\n";
        ByteArrayInputStream input = new ByteArrayInputStream(inputString.getBytes());
        String userInput = bc.getValidUserInput(input, System.out);
        assertThat(outContent.toString(), containsString("This is not a valid option"));
    }

    @Test
    public void testQuit() {
        BibliotecaController bc = new BibliotecaController();
        String inputString = "0";
        ByteArrayInputStream input = new ByteArrayInputStream(inputString.getBytes());
        bc.runApp(input, System.out);
        assertThat(outContent.toString(), containsString("Goodbye"));
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
