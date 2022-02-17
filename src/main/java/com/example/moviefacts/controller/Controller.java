package com.example.moviefacts.controller;


import com.example.moviefacts.model.Movie;
import com.example.moviefacts.services.Services;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controller {
    static Services service = new Services();

    @GetMapping("/")
    public String test(){
        return "Hello my friend, and welcome to the beta-version of IMDB ala DAT21A. <br><br><br>You have a couple options here. In the browser you can search for these things:<br>" +
                "<br>localhost:8080/getFirst" +
                "<br>localhost:8080/getRandom" +
                "<br>localhost:8080/getTenSortByPopularity" +
                "<br>localhost:8080/howManyWonAward" +
                "<br>localhost:8080/filter?character=<b>\"Your character\"</b>&amount=<b>\"Your amount\"</B>";
    }

    @GetMapping("/getFirst")
    public String getFirst(){
        return service.getFirst();
    }


    @GetMapping("/getRandom")
    public String getRandom(){
        return service.getRandom();
    }

    @GetMapping("/getTenSortByPopularity")
    public String getTenSortByPopularity(){
        return service.getTenSortByPopularity();
    }

    @GetMapping("/howManyWonAward")
    public String howManyWonAward(){
        return service.howManyHasWonAnAward();
    }

    @GetMapping("/filter")
    public String filter(@RequestParam char character, int amount){
        return service.howManyMoviesContains(character, amount);
    }
}
