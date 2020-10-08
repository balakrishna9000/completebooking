package com.dxctraining.booking.service;

import java.math.BigInteger;
import java.util.List;

import com.dxctraining.booking.entities.Booking;

public interface IBookingService {
	
Booking addBooking(Booking booking);
		
	Booking viewByBookingId(BigInteger bookingId);
	
	List<Booking>viewAllBookings();
	
	void deleteBooking(BigInteger bookingId);
	
	void validateBooking(Object obj);
	

}
