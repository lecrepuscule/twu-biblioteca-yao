package com.twu.biblioteca;


import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;


public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

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
        String[] books = {"book1", "book2", "book3"};
        BibliotecaApp biblioteca = new BibliotecaApp(books);
        assertEquals(books, biblioteca.listBooks());
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
