package com.example.moviefacts.model;

public class Movie implements Comparable<Movie>{
    private int year;
    private int lenght;
    private String title;
    private String subject;
    private int popularity;
    private boolean awards;

    public Movie(int year, int lenght, String title, String subject, int popularity, boolean awards){
        this.year = year;
        this.lenght = lenght;
        this.title = title;
        this.subject = subject;
        this.popularity = popularity;
        this.awards = awards;
    }

    public int getYear() {
        return year;
    }

    public int getLenght() {
        return lenght;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public int getPopularity() {
        return popularity;
    }

    public boolean isAwards() {
        return awards;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "year=" + year +
                ", lenght=" + lenght +
                ", title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", popularity=" + popularity +
                ", awards=" + awards +
                '}';
    }

    @Override
    public int compareTo(Movie o) {
        if (this.popularity == o.getPopularity()){
            return 0;
        }
        else if(this.popularity > o.getPopularity()){
            return 1;
        }
        else {
            return -1;
        }
    }
}
