package com.moviebookingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebookingapp.model.Movie;
import com.moviebookingapp.model.User;
import com.moviebookingapp.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	
	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@Override
	public Movie addMovie(Movie movie) {
		movie.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
		return movieRepository.save(movie);
	}

	@Override
	public Movie removeMovie(String moviename) {
		return movieRepository.deleteByMoviename(moviename); 
		
	}

	@Override
	public List<Movie> allMovies() {
		// TODO Auto-generated method stub
		return movieRepository.findAll();
	}

	@Override
	public List<Movie> findByMovie(String moviename) {
		// TODO Auto-generated method stub
		return movieRepository.findByMovienameLike(moviename);
	}

}
