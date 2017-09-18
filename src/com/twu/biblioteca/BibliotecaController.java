package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class BibliotecaController {

    private Biblioteca biblioteca = new Biblioteca();

    private String[] menu = {"1. List Books", "0. Quit"};
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

    public void actionCommand(String input) {
        if (input.equals("1")) {
            biblioteca.printBookList();
        } else if (input.equals("0")) {
            run = false;
        }
    }

    public String getValidUserInput(InputStream in, PrintStream out) {

        Scanner userInput = new Scanner(in);
        printMenu();
        String input = userInput.nextLine();

        while (!input.equals("1") && !input.equals("0")) {
            out.println("This is not a valid option");
            printMenu();
            input = userInput.nextLine();
        }

        return input;
    }

    public void runApp(InputStream in, PrintStream out) {
        String input;
        while (run) {
            input = getValidUserInput(in, out);
            actionCommand(input);
        }

        out.println("Goodbye");
    }
}
