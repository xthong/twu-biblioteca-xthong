package com.twu.biblioteca;

public class Movie {
    private String name;
    private String year;
    private String director;
    private int rate;

    public Movie(String name,String year,String director,int rate){
        this.name = name;
        this.year = year;
        this.director = director;
        this.rate = rate;
    }

    public String getName(){
        return this.name;
    }

    public String getYear() {
        return this.year;
    }

    public int getRate() {
        return this.rate;
    }

    public String getDirector() {
        return this.director;
    }
}
