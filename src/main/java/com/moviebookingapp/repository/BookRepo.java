package com.moviebookingapp.repository;
// Java Program to Illustrate BookRepo File

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.moviebookingapp.model.Book;

@Repository
public interface BookRepo
	extends MongoRepository<Book, Long> {
}
