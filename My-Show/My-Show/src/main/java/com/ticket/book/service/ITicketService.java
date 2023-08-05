package com.ticket.book.service;

import java.util.List;

import com.ticket.book.dto.TicketDTO;
import com.ticket.book.entity.Ticket;


public interface ITicketService {
   public String addTickets(TicketDTO ticketDto);
	
	public List<Ticket> getAllTickets();
	
	public String updateTickets(TicketDTO ticketDto);
	
	public String deleteTickets(long id);
	
	public Ticket getTicketById(long id);
	
	public List<Ticket> getSortedTicket();


}
