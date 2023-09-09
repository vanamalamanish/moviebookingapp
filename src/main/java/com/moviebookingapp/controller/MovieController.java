package com.moviebookingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moviebookingapp.model.Movie;
import com.moviebookingapp.service.MovieService;

@RestController
@RequestMapping("/api/v1.0/moviebooking/")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@PostMapping("/addMovie")
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
		return new ResponseEntity<Movie>(movieService.addMovie(movie),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteMovie")
	public ResponseEntity<Movie> deleteMovie(@RequestParam String moviename){
		return new ResponseEntity<Movie>(movieService.removeMovie(moviename),HttpStatus.OK);
	}
	
	@GetMapping("all")
	public ResponseEntity<List<Movie>> allMovies(){
		return new ResponseEntity<>(movieService.allMovies(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("movies/search/{moviename}")
	public ResponseEntity<List<Movie>> searchMovie(@PathVariable String moviename){
		return new ResponseEntity<List<Movie>>(movieService.findByMovie(moviename),HttpStatus.OK);
	}
	
	
}
