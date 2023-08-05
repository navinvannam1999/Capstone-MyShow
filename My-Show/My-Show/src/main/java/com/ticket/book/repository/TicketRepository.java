package com.ticket.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticket.book.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
