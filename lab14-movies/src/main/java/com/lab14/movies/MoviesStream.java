package com.lab14.movies;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MoviesStream {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("Inception", "Sci-Fi", 8.8, 2010),
            new Movie("Interstellar", "Sci-Fi", 8.6, 2014),
            new Movie("The Dark Knight", "Action", 9.0, 2008),
            new Movie("Tenet", "Sci-Fi", 7.5, 2020),
            new Movie("The Prestige", "Drama", 8.5, 2006),
            new Movie("Memento", "Thriller", 8.4, 2000),
            new Movie("Dunkirk", "War", 7.9, 2017)
        );

        // TODO: Solve the tasks here

        // getMoviesSortedByRatingDesc(movies);

        // getAvgRatingAfter2010(movies);

        // getMoviesByGenre(movies);

        //getHighestRatedMovieByGenre(movies);

        //getCountOfMoviesRatedHigherThanRating(movies, 8.9);

        //getStringOfAllMovies(movies);

        getMovieSummaryStats(movies);

    }

    public static void getMoviesSortedByRatingDesc(List<Movie> movies){
        
        System.out.println(" ---- GETTING TOP RATED SCI-FI MOVIES ---- ");

        List<Movie> sortedMovies = movies.stream()
            .filter(x -> x.getGenre().equals("Sci-Fi"))
            .sorted((m1, m2) -> Double.compare(m2.getRating(), m1.getRating()))
            .toList();

        sortedMovies.forEach(m -> System.out.println("Movie: " + m.getTitle() + " - Rating: " + m.getRating()));

        if(sortedMovies.isEmpty()){
            System.out.println(" ---- NO SCIFI MOVIES IN DATABASE ---- ");
        }
    }

    public static void getAvgRatingAfter2010(List<Movie> movies){
        
        System.out.println(" ---- GETTING AVERAGE RATING FOR MOVIES AFTER 2010 ---- ");

        double avgRating = movies.stream()
            .filter(x -> x.getYear() > 2010)
            .mapToDouble(m -> m.getRating())
            .average()
            .orElse(Double.NaN);

        if (Double.isNaN(avgRating)) {
            System.out.println(" ---- NO MOVIES IN DATABASE ---- ");
        } else {
            System.out.println("Average rating of movies after 2010: " + avgRating);
        }
    }


    public static void getMoviesByGenre(List<Movie> movies){
        
        System.out.println(" ---- GETTING ALL MOVIES BY GENRE ---- ");
        
        Map<String, List<Movie>> moviesByGenre = movies.stream()
            .collect(Collectors.groupingBy(m -> m.getGenre()));


        moviesByGenre.forEach((genre, movieList) -> {
            
            System.out.println("Genre: " + genre);
            movieList.forEach(movie -> System.out.println("  - " + movie.getTitle()));
            System.out.println();

        });


        if(moviesByGenre.isEmpty()){
            System.out.println(" ---- NO MOVIES IN DATABASE ---- ");
        }
    }

    public static void getHighestRatedMovieByGenre(List<Movie> movies){
        
        System.out.println(" ---- GETTING TOP RATED MOVIE BY GENRE ---- ");
        
        Map<String, Optional<Movie>> highestMovieByGenre = movies.stream()
            .collect(Collectors.groupingBy(
                m -> m.getGenre(),
                Collectors.maxBy(Comparator.comparing(m -> m.getRating()))
                ));


        highestMovieByGenre.forEach((genre, movieList) -> {
            
            System.out.println("Genre: " + genre);

            if(movieList.isPresent()){
                Movie movie = movieList.get();
                System.out.println(movie.getTitle() + " (Rating: " + movie.getRating() + ")");
            } else {
                System.out.println(" No movie for this genre ");
            }

            System.out.println();

        });


        if(highestMovieByGenre.isEmpty()){
            System.out.println(" ---- NO MOVIES IN DATABASE ---- ");
        }
    }

    public static void getCountOfMoviesRatedHigherThanRating(List<Movie> movies, double rating){
        
        System.out.println(" ---- GETTING COUNT OF MOVIES RATED HIGHER THAN " + rating + "---- ");
        
        long movieCount = movies.stream()
            .filter(x -> x.getRating() > rating)
            .count();

        System.out.println("There are " + movieCount + " rated higher than " + rating);


    }

    public static void getStringOfAllMovies(List<Movie> movies){
        
        System.out.println(" ---- GETTING MOVIE NAME STRING ---- ");
        
        String movieNames = movies.stream()
            .map(m -> m.getTitle())
            .sorted()
            .collect(Collectors.joining(", "));

        System.out.println(movieNames);


    }

    public static void getMovieSummaryStats(List<Movie> movies){
        
        System.out.println(" ---- GETTING SUMMARY STATS ---- ");
        
        IntSummaryStatistics yearStats = movies.stream()
            .mapToInt(m -> m.getYear())
            .summaryStatistics();

        System.out.printf("Movie Release Years Statistics:%n");
        System.out.printf("  Total Movies: %d%n", yearStats.getCount());
        System.out.printf("  Year Range: %d - %d%n", yearStats.getMin(), yearStats.getMax());
        System.out.printf("  Average Year: %.1f%n", yearStats.getAverage());
        System.out.printf("  Span: %d years%n", yearStats.getMax() - yearStats.getMin());


    }


    
}

