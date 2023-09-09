package com.moviebookingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebookingapp.model.Ticket;
import com.moviebookingapp.service.TicketService;

@RestController
@RequestMapping("/api/v1.0/moviebooking/")
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@PostMapping("{moviename}/add")
	public ResponseEntity<Ticket> addTicket(@PathVariable String moviename,@RequestBody Ticket ticket){
		return new ResponseEntity<Ticket>(ticketService.addTicket(ticket),HttpStatus.OK);
	}
	
}
