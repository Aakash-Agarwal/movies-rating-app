package com.aakash.learning.movies.controllers;

import com.aakash.learning.movies.data.Movie;
import com.aakash.learning.movies.data.Review;
import com.aakash.learning.movies.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = moviesService.getAllMovies();

        return ResponseEntity.status(HttpStatus.OK).body(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable String id) {
        Movie movie = moviesService.getMovieById(id);

        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        movie = moviesService.createMovie(movie);

        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }
}
