package com.ticket.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="booking_id")
	private long id;
	
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "user_id")
	private User user;
	
	@ManyToOne()
	@JoinColumn(name = "ticket_id")
	private Ticket ticket;
	
    private  Integer unit;
	
	private double totalPrice;
	
	public Booking(User user, Ticket ticket) {
		this.user = user;
		this.ticket = ticket;
	}

	public Booking() {
		
	}

	public Booking(long id, User user, Ticket ticket, Integer unit, double totalPrice) {
		super();
		this.id = id;
		this.user = user;
		this.ticket = ticket;
		this.unit = unit;
		this.totalPrice = totalPrice;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Integer getUnit() {
		return unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", user=" + user + ", ticket=" + ticket + ", unit=" + unit + ", totalPrice="
				+ totalPrice + "]";
	}

	

}
