package org.example;

import java.util.ArrayList;

public interface MovieStorage {

    ArrayList<Movie> findAll();

    Movie findMovieByName(String name);

    void addMovie(Movie movie);

    
}
