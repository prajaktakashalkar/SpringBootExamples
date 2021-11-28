package com.vapasi.springboot.movies.service;

import com.vapasi.springboot.movies.dto.Movie;
import com.vapasi.springboot.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovieList(){
       return movieRepository.getMovieList();
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.saveMovie(movie);
    }

    public Movie updateMovie(Movie movie) {
        return movieRepository.updateMovie(movie);
    }
}
