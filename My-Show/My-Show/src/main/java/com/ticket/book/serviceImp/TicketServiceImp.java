package com.ticket.book.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ticket.book.dto.TicketDTO;
import com.ticket.book.entity.Ticket;
import com.ticket.book.repository.TicketRepository;
import com.ticket.book.service.ITicketService;


@Service
public class TicketServiceImp implements ITicketService{
	
	@Autowired
	private TicketRepository repo;
	
	@Override
    public String addTickets(TicketDTO ticketDto) {
		Ticket product = new Ticket();
		product.setName(ticketDto.getName());
		product.setPrice(ticketDto.getPrice());
		product.setUrl(ticketDto.getUrl());
		product.setCategory(ticketDto.getCatagory());
		product.setQuantity(ticketDto.getQuantity());
		
		repo.save(product);
		return "New ticket Is saved";
	}
	
	@Override
	public List<Ticket> getAllTickets(){
		return repo.findAll();	
	}
	
	@Override
	public String updateTickets(TicketDTO ticketDto) {
		Ticket product = new Ticket();
		product.setId(ticketDto.getId());
		product.setName(ticketDto.getName());
		product.setPrice(ticketDto.getPrice());
		product.setUrl(ticketDto.getUrl());
		product.setCategory(ticketDto.getCatagory());
		product.setQuantity(ticketDto.getQuantity());
		
		repo.save(product);
		return "Ticket is Updated";
	}
	
	@Override
	public String deleteTickets(long id) {
		
		repo.deleteById(id);
		return "Ticket is Deleted";
	}
	
	@Override
	public Ticket getTicketById(long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Ticket> getSortedTicket(){
		return repo.findAll(Sort.by("category"));
		
	}


}
