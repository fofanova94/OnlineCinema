package org.example;

public class Movie {
private int id;
    private String name;
    private int year;
    private String genre;
    private String actors;

    public Movie(int id, String name, int year, String genre, String actors) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.actors = actors;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return "Name: " +  name + ".  Год: " + year + ". Жанр: " + genre + ". Актеры:" + actors;
    }

}
