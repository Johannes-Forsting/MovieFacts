package com.example.moviefacts.services;

import com.example.moviefacts.model.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieLoader {

    static ArrayList<Movie> movies = new ArrayList<Movie>();

    public static void movieLoader() {
        File f = new File("src/main/resources/imdb-data.csv");
        try {
            Scanner scanner = new Scanner(f);
            scanner.nextLine();
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                String[] lineSplittet = line.split(";");
                movies.add(getMovie(lineSplittet));
            }
        }
        catch (Exception e){

        }
    }

    private static Movie getMovie(String[] movieString){
        int year = Integer.parseInt(movieString[0]);
        int lenght = Integer.parseInt(movieString[1]);
        String title = movieString[2];
        String subject = movieString[3];
        int popularity = Integer.parseInt(movieString[4]);
        boolean hasAward = movieString[5].equalsIgnoreCase("yes") ? true : false;
        Movie movie = new Movie(year, lenght, title, subject, popularity, hasAward);
        return movie;
    }




}
