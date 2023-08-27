package com.moviebookingapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "database_sequences")
@Getter
@Setter
public class DatabaseSequence {

	@Id
	private String id;

	private long seq;

	// getters and setters omitted
}