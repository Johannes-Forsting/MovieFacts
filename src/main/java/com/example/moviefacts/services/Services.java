package com.example.moviefacts.services;

import com.example.moviefacts.model.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Services {
    static Random random = new Random();
    public String getFirst(){
        return MovieLoader.movies.get(0).getTitle();
    }

    public Movie getRandomMovie(){
        int randomNumber = random.nextInt(MovieLoader.movies.size());
        return MovieLoader.movies.get(randomNumber);
    }

    public String getRandom(){
        Movie movie = getRandomMovie();
        return movie.getTitle();
    }


    public String getTenSortByPopularity(){
        ArrayList<Movie> tenMoviesSorted = new ArrayList<Movie>();
        for (int i = 0; i < 10; i++) {
            Movie currentMovie = getRandomMovie();
            tenMoviesSorted.add(currentMovie);
        }
        Collections.sort(tenMoviesSorted);

        String returnString = "<h1 style=color:#CA0000>Ten random movies sorted by popularity</h1> <br>";

        for (int i = 0; i < tenMoviesSorted.size(); i++) {
            returnString += "<b>Title</b>: " + tenMoviesSorted.get(i).getTitle() + "<br>";
            returnString += "<b>Popularity:</b> " + tenMoviesSorted.get(i).getPopularity();
            returnString += "<br><br>";
        }
        return returnString;
    }

    public String howManyHasWonAnAward(){
        int count = 0;
        for (int i = 0; i < MovieLoader.movies.size(); i++) {
            if(MovieLoader.movies.get(i).isAwards()){
                count++;
            }
        }
        return "In this list of movies " + count + " movies has won an award.";
    }


    public String howManyMoviesContains(char ch, int amount){
        ArrayList<Movie> moviesWithSpecialRequirements = new ArrayList<Movie>();
        for (int i = 0; i < MovieLoader.movies.size(); i++) {
            Movie currentMovie = MovieLoader.movies.get(i);
            if (doesMovieApply(currentMovie, ch, amount)){
                moviesWithSpecialRequirements.add(currentMovie);
            }
        }
        String stringToReturn = "All the movies with the character: \"" + ch + "\" " + amount + " amount of times is these: <br><br>";
        for (int i = 0; i < moviesWithSpecialRequirements.size(); i++) {
            stringToReturn += moviesWithSpecialRequirements.get(i).getTitle() + "<br>";
        }
        return stringToReturn;
    }

    private boolean doesMovieApply(Movie movie, char ch, int amount){
        String title = movie.getTitle().toLowerCase();
        int count = 0;
        for (int i = 0; i < title.length(); i++) {
            char currentChar = title.charAt(i);
            if(currentChar == ch){
                count ++;
            }
        }
        if(count == amount){
            return true;
        }
        else {
            return false;
        }
    }

}
