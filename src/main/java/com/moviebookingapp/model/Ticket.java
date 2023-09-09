package com.moviebookingapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Ticket")
public class Ticket {

	@Transient
    public static final String SEQUENCE_NAME = "ticket_sequence";
	
	@Id
	private long id;
	
	private String moviename;
	private String theatrename;
	private int nooftickets;
	private String seats;
}
