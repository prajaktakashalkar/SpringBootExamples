package com.vapasi.springboot.movies.controller;

import com.vapasi.springboot.movies.dto.Movie;
import com.vapasi.springboot.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Movie>> getMovieList(){
        return ResponseEntity.ok().body(movieService.getMovieList());
    }

    @PostMapping("/")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
        Movie movieWithId = movieService.saveMovie(movie);
        return new ResponseEntity<Movie>(movieWithId,HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie){
        Movie updatedMovie=movieService.updateMovie(movie);
        return new ResponseEntity<>(updatedMovie,HttpStatus.ACCEPTED);
    }
}
