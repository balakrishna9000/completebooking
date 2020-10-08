package com.dxctraining.booking.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dxctraining.booking.dao.IBookingDao;
import com.dxctraining.booking.entities.Booking;
import com.dxctraining.booking.exceptions.BookingNotFoundException;
import com.dxctraining.booking.exceptions.InvalidArgumentException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class IBookingServiceImpl implements IBookingService {
	
@Autowired
IBookingDao dao;

@Override
public Booking viewByBookingId(BigInteger bookingId) {
	Optional<Booking> optional = dao.findById(bookingId);
	if (!optional.isPresent()) {
		throw new BookingNotFoundException("Booking not found for the given booking Id");
	}
	Booking booking = optional.get();
	return booking;
}

@Override
public List<Booking> viewAllBookings(){
	return dao.findAll();
	
}

@Override
public void deleteBooking (BigInteger bookingId){
	validateBooking (bookingId);
	dao.deleteById(bookingId);
}



@Override
public void validateBooking(Object obj) {
	if(obj==null) {
		throw new InvalidArgumentException("given argument is not valid "+obj);
	}
}

@Override
public Booking addBooking(Booking booking) {
	validateBooking(booking);
	return dao.save(booking);
}
}
