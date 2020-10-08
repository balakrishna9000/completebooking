package com.dxctraining.booking.util;

import com.dxctraining.booking.dto.BookingDto;
import com.dxctraining.booking.entities.Booking;

import java.math.BigInteger;

import org.springframework.stereotype.Component;

@Component
public class BookingUtil {
	
	public BookingDto bookingDto(Booking booking,Integer userId,String userType, String userName, String email, Long userPhone, String password,BigInteger passengerNum, String passengerName,int passengerAge, BigInteger passengerUIN,double luggage, BigInteger scheduleFlightId,Integer availableSeats,Integer scheduleId,BigInteger flightNumber) {
		BookingDto dto = new BookingDto(booking.getBookingId(),booking.getBookingDate(), booking.getTicketCost());
		dto.setUserId(userId);
		dto.setUserType(userType);
		dto.setUserName(userName);
		dto.setEmail(email);
		dto.setUserPhone(userPhone);
		dto.setPassword(password);
		dto.setPassengerNum(passengerNum);
		dto.setPassengerName(passengerName);
		dto.setPassengerAge(passengerAge);
		dto.setPassengerUIN(passengerUIN);
		dto.setLuggage(luggage);
		dto.setScheduleFlightId(scheduleFlightId);
		dto.setAvailableSeats(availableSeats);
		dto.setScheduleId(scheduleId);
		dto.setFlightNumber(flightNumber);
		return dto;
	}}

