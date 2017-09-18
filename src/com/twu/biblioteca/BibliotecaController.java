package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class BibliotecaController {

    private Biblioteca biblioteca = new Biblioteca();

    private String[] menu = {"1. List Books", "0. Quit"};
    private Boolean run = true;

    public void printMenu() {
        System.out.println("Please type in the number from menu: ");
        for (String item : menu) {
            System.out.println(item);
        }
    }

    public void actionCommand(String input) {
        if (input == "1") {
            biblioteca.printBookList();
        } else if (input == "0") {
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

    public void runApp() {

        System.out.println("Welcome to Biblioteca");

        while (run) {
            String input = getValidUserInput(System.in, System.out);
            actionCommand(input);
        }

        System.out.println("Goodbye");
    }
}
