package com.moviebookingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebookingapp.model.Ticket;
import com.moviebookingapp.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	public Ticket addTicket(Ticket ticket) {
		ticket.setId(sequenceGeneratorService.generateSequence(Ticket.SEQUENCE_NAME));
		return ticketRepository.save(ticket);
	}
}
