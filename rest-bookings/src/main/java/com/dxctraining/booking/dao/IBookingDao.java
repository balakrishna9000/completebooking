package com.dxctraining.booking.dao;

import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dxctraining.booking.entities.Booking;

public interface IBookingDao extends JpaRepository<Booking, BigInteger>{
		
	

}
