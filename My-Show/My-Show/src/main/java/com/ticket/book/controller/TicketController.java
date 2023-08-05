package com.ticket.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.book.dto.TicketDTO;
import com.ticket.book.entity.Ticket;
import com.ticket.book.service.ITicketService;


@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/tickets")
public class TicketController {
	
	@Autowired
	private ITicketService service; 
	
	@PostMapping("/add-ticket")
	public String addTickets(@RequestBody TicketDTO dto) {
		return service.addTickets(dto);
	}
	
	@GetMapping("/getAll")
    public List<Ticket> getAllTickets(){
		return service.getAllTickets();
    	
    }
	
	@PutMapping("/updateTicket")
	public String updateTickets(@RequestBody TicketDTO dto) {
		return service.updateTickets(dto);
	}
	
	@DeleteMapping("/deleteTicket/{id}")
	public String deleteTickets(@PathVariable long id) {
		return service.deleteTickets(id);
	}
	
	@GetMapping("/get-ticket/{id}")
	public Ticket getTicketById(@PathVariable long id) {
		return service.getTicketById(id);
	}
	
	@GetMapping("/get-sorted-ticket")
	public List<Ticket> getSortedTicket(){
		return service.getSortedTicket();
	}

}
