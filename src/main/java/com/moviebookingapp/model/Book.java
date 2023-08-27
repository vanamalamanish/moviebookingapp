package com.moviebookingapp.model;
// Java Program to illustrate Book File

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

// Importing required classes
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Book")

// Class
public class Book
{

	@Transient
    public static final String SEQUENCE_NAME = "books_sequence";
	// Attributes
	@Id
	private long id;
	private String bookName;
	private String authorName;
}
