package com.vapasi.springboot.movies.repository;

import com.vapasi.springboot.movies.dto.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class MovieRepository {

    List<Movie> movieList=new ArrayList<Movie>(Arrays.asList(
            new Movie(1,"3 Idiots","Amir Khan","Rajkumar Hirani"),
            new Movie(2,"Lagan","Amir Khan","Ashutosh Gowarikar")));

    public List<Movie> getMovieList(){
        return movieList;
    }

    public Movie saveMovie(Movie movie) {
        int movieId=movieList.get(movieList.size()-1).getId()+1;
        Movie movieToBeAdded= new Movie(movieId,movie.getName(), movie.getActor(), movie.getDirector());
        movieList.add(movieToBeAdded);
        return movieToBeAdded;
    }

    public Movie updateMovie(Movie updatedMovie) {
        //int movieId=updatedMovie.getId();
        Movie movieToBeUpdated= movieList.stream().filter(movie -> movie.getId()==updatedMovie.getId()).findAny().get();
        movieToBeUpdated.setName(updatedMovie.getName());
        movieToBeUpdated.setActor(updatedMovie.getActor());
        movieToBeUpdated.setDirector(updatedMovie.getDirector());
        return movieToBeUpdated;
    }
}
