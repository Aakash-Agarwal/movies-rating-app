package com.aakash.learning.movies.data;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
public class Review {
    private String movieId;
    private String text;
}
