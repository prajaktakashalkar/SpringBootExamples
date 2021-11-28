package com.vapasi.springboot.movies.service;

import com.vapasi.springboot.movies.dto.Movie;
import com.vapasi.springboot.movies.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MovieServiceTest {

    MovieService movieService;
    MovieRepository movieRepository;

    @BeforeEach
    void setUp(){
        movieRepository=mock(MovieRepository.class);
        movieService=new MovieService(movieRepository);
    }

    @Test
    void getMovieList(){
        List<Movie> movieList=new ArrayList<Movie>(Arrays.asList(
                new Movie(1,"3 Idiots","Amir Khan","Rajkumar Hirani"),
                new Movie(2,"Lagan","Amir Khan","Ashutosh Gowarikar")));
        when(movieRepository.getMovieList()).thenReturn(movieList);
        List<Movie> allMovies=movieService.getMovieList();
        verify(movieRepository,times(1)).getMovieList();
        assertEquals(movieList,allMovies);

    }

    @Test
    void shouldUpdateMovie(){
        Movie updatedMovie=new Movie(1,"vapasi","developers","vapasi");
        when(movieRepository.updateMovie(updatedMovie)).thenReturn(updatedMovie);
        Movie movie=movieService.updateMovie(updatedMovie);
        verify(movieRepository,times(1)).updateMovie(updatedMovie);
        assertEquals(updatedMovie,movie);
    }
}
