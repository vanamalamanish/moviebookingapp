package com.moviebookingapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleCustomException(Exception customException) {
		return new ResponseEntity<String>(customException.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
