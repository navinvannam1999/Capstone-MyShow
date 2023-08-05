package com.ticket.book.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.book.entity.Booking;
import com.ticket.book.repository.BookingRepository;
import com.ticket.book.service.IBookingService;

@Service
public class BookingServiceImp implements IBookingService{
		
	@Autowired
	private BookingRepository repo;
	
	@Override
    public Booking addToBooking(Booking booking) {
		return repo.save(booking);
	}
	
	@Override
	public List<Booking> getAllByUserBooking(long id){
		return repo.findAllByUserId(id);
	}
	
	@Override
	public void deleteBooking(long id) {
		 repo.deleteById(id);
	}
	
	@Override
	public void updateBooking(Booking booking,long cid) {
		Booking updated = repo.findById(cid).get();
		updated = booking;
		repo.save(updated);
	}


}
