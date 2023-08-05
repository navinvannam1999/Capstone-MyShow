package com.ticket.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.book.entity.Booking;
import com.ticket.book.entity.Ticket;
import com.ticket.book.entity.User;
import com.ticket.book.service.IBookingService;
import com.ticket.book.service.ITicketService;
import com.ticket.book.service.IUserService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private IBookingService service;

	@Autowired
	private IUserService userService;

	@Autowired
	private ITicketService ticketService;

	@GetMapping("/getall/{userId}")
	public List<Booking> getBooking(@PathVariable long userId) {
		return service.getAllByUserBooking(userId);
	}

	@GetMapping("/add/{ticketId}/{userId}")
	public ResponseEntity<Booking> addBooking(@PathVariable long ticketId,@PathVariable long userId) {

		Ticket ticket = ticketService.getTicketById(ticketId);
		User user = userService.getUserById(userId);
		Booking booking = new Booking(user, ticket);
		booking.setUnit(1);
		booking.setTotalPrice(booking.getUnit()*ticket.getPrice());
		Booking addBooking = service.addToBooking(booking);
		return new ResponseEntity<Booking>(addBooking, HttpStatus.CREATED);

	}

	@DeleteMapping("/delete/{bookingId}")
	public ResponseEntity<?> deleteBooking(@PathVariable long bookingId) {

		service.deleteBooking(bookingId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/update-Booking/{bid}")
	public void updateBooking(@RequestBody Booking booking, @PathVariable long bid) {
		service.updateBooking(booking, bid);
		
	}

}
