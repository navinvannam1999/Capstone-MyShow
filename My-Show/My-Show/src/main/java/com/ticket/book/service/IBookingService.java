package com.ticket.book.service;

import java.util.List;

import com.ticket.book.entity.Booking;


public interface IBookingService {
	    public Booking addToBooking(Booking booking);
		
		public List<Booking> getAllByUserBooking(long id);
		
		public void deleteBooking(long id);
		
		public void updateBooking(Booking booking,long cid);

}
