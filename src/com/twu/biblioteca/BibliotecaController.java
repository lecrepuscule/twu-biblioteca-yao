package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaController {

    private Biblioteca biblioteca = new Biblioteca();

    private String[] menu = {"1. List Books", "0. Quit"};
    private Boolean run = true;

    public void printMenu() {
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

    public void runApp() {
        System.out.println("Welcome to Biblioteca");

        Scanner userInput = new Scanner(System.in);

        while (run) {
            System.out.println("Please type in the number from menu: ");
            printMenu();
            String input = userInput.nextLine();
            actionCommand(input);
        }

        System.out.println("Goodbye");
    }
}
