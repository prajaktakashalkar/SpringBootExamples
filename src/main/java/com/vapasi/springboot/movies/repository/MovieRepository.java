package com.vapasi.springboot.movies.repository;

import com.vapasi.springboot.movies.dto.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {

    List<Movie> movieList=new ArrayList<>();

    public List<Movie> getMovieList(){
        movieList.add(new Movie("3 Idiots","Amir Khan","Rajkumar Hirani"));
        movieList.add(new Movie("Lagan","Amir Khan","Ashutosh Gowarikar"));
        return movieList;
    }
}
