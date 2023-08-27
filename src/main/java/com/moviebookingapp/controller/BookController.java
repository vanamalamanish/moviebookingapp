package com.moviebookingapp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviebookingapp.model.Book;
import com.moviebookingapp.repository.BookRepo;
import com.moviebookingapp.service.SequenceGeneratorService;

// Annotation
@RestController

// Class
public class BookController {

	@Autowired
	private BookRepo repo;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book){
		book.setId(sequenceGeneratorService.generateSequence(Book.SEQUENCE_NAME));
		repo.save(book);
	
		return "Added Successfully";
	}

	@GetMapping("/findAllBooks")
	public List<Book> getBooks() {
	
		return repo.findAll();
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable long id){
		repo.deleteById(id);
	
		return "Deleted Successfully";
	}

}
