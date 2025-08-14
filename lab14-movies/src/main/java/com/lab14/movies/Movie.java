package com.lab14.movies;

class Movie {
    String title;
    String genre;
    double rating;
    int year;

    public Movie(String title, String genre, double rating, int year) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.year = year;
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public double getRating() { return rating; }
    public int getYear() { return year; }

    @Override
    public String toString() {
        return title + " (" + year + ") - " + rating;
    }
}

