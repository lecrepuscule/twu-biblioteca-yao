package com.twu.biblioteca;

public class Movie {
    private int id;
    private String name;
    private String director;
    private int year;
    private int rating;
    private Boolean checkedOut = false;

    public Movie(int id, String name, String director, int year, int rating) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public int getId() { return id; }

    public int getRating() { return rating; }

    public Boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(Boolean status) {
        checkedOut = status;
    }

}
