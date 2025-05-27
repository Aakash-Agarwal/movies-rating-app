package com.aakash.learning.movies.services;

import com.aakash.learning.movies.data.Movie;
import com.aakash.learning.movies.repositories.MoviesRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

    public List<Movie> getAllMovies() {
        return moviesRepository.findAll();
    }

    public Movie getMovieById(String id) {
        return moviesRepository.findById(new ObjectId(id)).orElse(new Movie());
    }

    public Movie createMovie(Movie movie) {
        return moviesRepository.save(movie);
    }
}
