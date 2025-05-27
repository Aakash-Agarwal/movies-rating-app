package com.aakash.learning.movies.controllers;

import com.aakash.learning.movies.data.Movie;
import com.aakash.learning.movies.data.Review;
import com.aakash.learning.movies.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewsController {
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Movie> addReview(@RequestBody Review review) {
        Movie movie = reviewService.addReview(review);
        if (movie == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }
}
