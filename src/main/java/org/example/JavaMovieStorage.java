package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class JavaMovieStorage {
    private ArrayList<Movie> movies = new ArrayList<Movie>();

    public JavaMovieStorage() {
        Movie m1 = new Movie(1,"Harry Potter", 2000, "Fantasy", "Daniel Redcliff");
        Movie m2 = new Movie(2,"Game of Thrones", 2011, "Adventure", "Sean Bean");
        addFilms(m1);
        addFilms(m2);
    }

    public void addFilms(Movie films) {
        movies.add(films);
    }

    public void printFilms() {
        for (int i = 0; i < movies.size(); i++) {
            Movie u = movies.get(i);
            System.out.println(u);
        }
    }

    public Movie findFilms(String nameFilm){
        for (int i = 0; i < movies.size(); i++){
            Movie n = movies.get(i);
            if (n.getName().equals(nameFilm)){
                return n;
            }
        }

        return null;
    }

}


