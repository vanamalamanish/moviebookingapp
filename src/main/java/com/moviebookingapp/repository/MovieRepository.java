package com.moviebookingapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.moviebookingapp.model.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie,Long> {
	List<Movie> findByMovienameLike(String moviename);
	Movie deleteByMoviename(String moviename);
}
