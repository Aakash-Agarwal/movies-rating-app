package com.aakash.learning.movies.services;

import com.aakash.learning.movies.data.Movie;
import com.aakash.learning.movies.data.Review;
import com.aakash.learning.movies.repositories.MoviesRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final MoviesRepository moviesRepository;

    public Movie addReview(Review review) {
        Movie movie = moviesRepository.findById(new ObjectId(Optional.ofNullable(review.getMovieId()).orElse("")))
                .orElse(null);

        if (movie == null) {
            return null;
        }

        movie.getReviews().add(review.getText());
        moviesRepository.save(movie);

        return movie;
    }
}
