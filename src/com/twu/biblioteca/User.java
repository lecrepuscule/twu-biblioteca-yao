package com.twu.biblioteca;

public class User {
    private int libraryNumber;
    private String password;
    private String name;
    private String email;
    private int phone;

    public User(int libraryNumber, String password, String name, String email, int phone){
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;

    }

    public int getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public int getLibraryNumber() {
        return libraryNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
