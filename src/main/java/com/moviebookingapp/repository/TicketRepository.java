package com.moviebookingapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.moviebookingapp.model.Ticket;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, Long> {

}
