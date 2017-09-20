package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class BibliotecaController {

    private Biblioteca biblioteca = new Biblioteca();

    private String[] menu = {"1. List Books", "2. Check-out a book", "3. Return a book", "0. Quit"};
    private Boolean run = true;

    public BibliotecaController() {
        System.out.println("Welcome to Biblioteca");
    }

    public void printMenu() {
        System.out.println("Please type in the number from menu: ");
        for (String item : menu) {
            System.out.println(item);
        }
    }

    public void actionCommand(int input, InputStream in, PrintStream out) {
        if (input == 1) {
            biblioteca.printBookList();
        } else if (input == 2) {
            int bookId = getValidBookId(in, out, "checkout");
            biblioteca.checkoutBook(bookId);
            out.println("Thank you! Enjoy the book.");
        } else if (input == 3) {
            int bookId = getValidBookId(in, out, "return");
            biblioteca.returnBook(bookId);
            out.println("Thank you for returning the book.");
        } else if (input == 0) {
            run = false;
        }
    }

    public int getValidBookId(InputStream in, PrintStream out, String condition) {
        Scanner userInput = new Scanner(in);
        out.println("Please type in the book ID: ");
        biblioteca.printBookList();
        int input = userInput.nextInt();

        if (condition.equals("checkout")) {
            while (!biblioteca.canCheckoutBook(input)) {
                out.println("That book is not available.");
                biblioteca.printBookList();
                input = userInput.nextInt();
            }
        } else if (condition.equals("return")) {
            while (!biblioteca.canReturnBook(input)) {
                out.println("That is not a valid book to return.");
                biblioteca.printBookList();
                input = userInput.nextInt();
            }
        }

        return input;
    }

    public int getValidUserInput(InputStream in, PrintStream out) {

        Scanner userInput = new Scanner(in);
        printMenu();
        int input = userInput.nextInt();

        while (input != 1 && input != 0 && input != 2 && input != 3) {
            out.println("This is not a valid option.");
            printMenu();
            input = userInput.nextInt();
        }
        return input;
    }

    public void runApp(InputStream in, PrintStream out) {
        int input;
        while (run) {
            input = getValidUserInput(in, out);
            actionCommand(input, in, out);
        }

        out.println("Goodbye.");
    }
}
