package com.moviebookingapp.repository;

import com.moviebookingapp.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie,Long> {
}
