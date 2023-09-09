package com.moviebookingapp.service;

import java.util.List;

import com.moviebookingapp.model.Movie;

public interface MovieService {

	public Movie addMovie(Movie movie);
	public Movie removeMovie(String moviename);
	public List<Movie> allMovies();
	public List<Movie> findByMovie(String moviename);
	
}
