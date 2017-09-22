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

    private Movie movie1 = new Movie(1, "movie1", "director1", 2005,4);
    private Movie movie2 = new Movie(2, "movie2", "director2", 2006, 2);

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
        assertThat(outContent.toString(), containsString("id: " + book1.getId() + "; title: " + book1.getTitle() + "; author: " + book1.getAuthor() + "; year: " + book1.getYear()
                + "\nid: " + book2.getId() + "; title: " + book2.getTitle() + "; author: " + book2.getAuthor() + "; year: " + book2.getYear()
                + "\nid: " + book3.getId() + "; title: " + book3.getTitle() + "; author: " + book3.getAuthor() + "; year: " + book3.getYear()
                + "\nid: " + book4.getId() + "; title: " + book4.getTitle() + "; author: " + book4.getAuthor() + "; year: " + book4.getYear() + "\n"));
    }


    @Test
    public void testMainMenu() {
        BibliotecaController bc = new BibliotecaController();
        bc.printMenu();
        assertThat(outContent.toString(), containsString("1. List Books\n" + "2. Check-out a book\n" + "3. Return a book\n" + "4. List Movies\n" + "5. Check-out a Movie\n" + "0. Quit\n"));
    }

    @Test
    public void testValidMenuOption() {
        BibliotecaController bc = new BibliotecaController();
        ByteArrayInputStream input = new ByteArrayInputStream("1".getBytes());
        int userInput = bc.getValidUserInput(input, System.out);
        assertEquals(1, userInput);
    }

    @Test
    public void testInvalidMenuOption() {
        BibliotecaController bc = new BibliotecaController();
        String inputString = "33\n" + "1\n";
        ByteArrayInputStream input = new ByteArrayInputStream(inputString.getBytes());
        int userInput = bc.getValidUserInput(input, System.out);
        assertThat(outContent.toString(), containsString("This is not a valid option."));
    }

    @Test
    public void testQuit() {
        BibliotecaController bc = new BibliotecaController();
        String inputString = "0";
        ByteArrayInputStream input = new ByteArrayInputStream(inputString.getBytes());
        bc.runApp(input, System.out);
        assertThat(outContent.toString(), containsString("Goodbye."));
    }

    @Test
    public void testValidBookId() {
        BibliotecaController bc = new BibliotecaController();
        ByteArrayInputStream input = new ByteArrayInputStream("1".getBytes());
        int userInput = bc.getValidBookId(input, System.out, "checkout");
        assertEquals(1, userInput);
    }

    @Test public void testInvalidBookId() {
        BibliotecaController bc = new BibliotecaController();
        String inputString = "-13\n" + "1\n";
        ByteArrayInputStream input = new ByteArrayInputStream(inputString.getBytes());
        int userInput = bc.getValidBookId(input, System.out, "checkout");
        assertThat(outContent.toString(), containsString("That book is not available."));
    }

    @Test
    public void testSuccessfulCheckout() {
        BibliotecaController bc = new BibliotecaController();
        String inputString = "2";
        ByteArrayInputStream input = new ByteArrayInputStream(inputString.getBytes());
        bc.actionCommand(2, input, System.out);
        assertThat(outContent.toString(), containsString("Thank you! Enjoy the book."));
    }


    @Test
    public void testSucessfulReturn() {
        BibliotecaController bc = new BibliotecaController();
        String inputString = "5";
        ByteArrayInputStream input = new ByteArrayInputStream(inputString.getBytes());
        bc.actionCommand(3, input, System.out);
        assertThat(outContent.toString(), containsString("Thank you for returning the book."));
    }

    @Test
    public void testUnsucessfulReturn() {

        BibliotecaController bc = new BibliotecaController();
        String inputString = "-13\n" + "5\n";
        ByteArrayInputStream input = new ByteArrayInputStream(inputString.getBytes());
        int userInput = bc.getValidBookId(input, System.out, "return");
        assertThat(outContent.toString(), containsString("That is not a valid book to return."));
    }

    @Test
    public void testListMovies() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.printMovieList();
        assertThat(outContent.toString(), containsString("id: " + movie1.getId() + "; name: " + movie1.getName() + "; director: " + movie1.getDirector() + "; year: " + movie1.getYear() + "; rating: " + movie1.getRating()
                + "\nid: " + movie2.getId() + "; name: " + movie2.getName() + "; director: " + movie2.getDirector() + "; year: " + movie2.getYear() + "; rating: " + movie2.getRating()));
    }

    @Test
    public void testSucessfulMovieCheckout(){

    }
}
