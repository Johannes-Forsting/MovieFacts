package com.example.moviefacts;

import com.example.moviefacts.model.Movie;
import com.example.moviefacts.services.MovieLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieFactsApplication {

    public static void main(String[] args) {
        MovieLoader.movieLoader();
        SpringApplication.run(MovieFactsApplication.class, args);
    }

}
