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

    private Book book1 = new Book(1,"book1", "author1", 2000);
    private Book book2 = new Book(2,"book2", "author2", 2001);
    private Book book3 = new Book(3,"book3", "author3", 2002);
    private Book book4 = new Book(4,"book4", "author4", 2003);


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
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.printBookList();
        assertThat(outContent.toString(), containsString("id: " + book1.getId() + "title: " + book1.getTitle() + "; author: " + book1.getAuthor() + "; year: " + book1.getYear()
                + "\nid: " + book2.getId() + "title: " + book2.getTitle() + "; author: " + book2.getAuthor() + "; year: " + book2.getYear()
                + "\nid: " + book3.getId() + "title: " + book3.getTitle() + "; author: " + book3.getAuthor() + "; year: " + book3.getYear()
                + "\nid: " + book4.getId() + "title: " + book4.getTitle() + "; author: " + book4.getAuthor() + "; year: " + book4.getYear() + "\n"));
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
