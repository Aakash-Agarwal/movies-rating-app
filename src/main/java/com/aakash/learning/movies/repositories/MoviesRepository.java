package com.aakash.learning.movies.repositories;

import com.aakash.learning.movies.data.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends MongoRepository<Movie, ObjectId> {
}
