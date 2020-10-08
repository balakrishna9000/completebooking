package com.dxctraining.booking.controllers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dxctraining.booking.dto.BookingDto;
import com.dxctraining.booking.dto.CreateBookingRequest;
import com.dxctraining.booking.dto.PassengerDto;
import com.dxctraining.booking.dto.ScheduledFlightDto;
import com.dxctraining.booking.dto.UserDto;
import com.dxctraining.booking.entities.Booking;
import com.dxctraining.booking.service.IBookingService;
import com.dxctraining.booking.util.BookingUtil;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bookings")
public class BookingController {

	@Autowired
	private IBookingService service;
	
	@Autowired
	private BookingUtil util;

	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public BookingDto createBooking(@RequestBody CreateBookingRequest req) {
		Booking booking = new Booking(req.getUserId(),req.getBookingDate(),req.getTicketCost(),req.getPassengerNum(),req.getScheduleFlightId());
		booking = service.addBooking(booking);
		UserDto userDto = findUserDetailsByUserId(req.getUserId());
		PassengerDto passengerDto = findPassengerDetailsByPassengerNum(req.getPassengerNum());
		ScheduledFlightDto scheduleFlightDto = findScheduledFlightById(req.getScheduleFlightId());
		BookingDto response = util.bookingDto(booking, userDto.getUserId(), userDto.getUserType(), userDto.getUserName(), userDto.getEmail(), userDto.getUserPhone(), userDto.getPassword(), passengerDto.getPassengerNum(), passengerDto.getPassengerName(), passengerDto.getPassengerAge(), passengerDto.getPassengerUIN(), passengerDto.getLuggage(), scheduleFlightDto.getScheduleflightId(), scheduleFlightDto.getAvailableSeats(), scheduleFlightDto.getScheduleId(), scheduleFlightDto.getFlightNumber());
		return response;

	}
	
	@GetMapping("/get/{bookingId}")
	@ResponseStatus(HttpStatus.OK)
	public BookingDto findBookingByBookingId(@PathVariable("bookingId") BigInteger bookingId) {
		Booking booking = service.viewByBookingId(bookingId);
		UserDto userDto = findUserDetailsByUserId(booking.getUserId());
		PassengerDto passengerDto = findPassengerDetailsByPassengerNum(booking.getPassengerNum());
		ScheduledFlightDto scheduleFlightDto = findScheduledFlightById(booking.getScheduleFlightId());
		BookingDto response = util.bookingDto(booking, userDto.getUserId(), userDto.getUserType(), userDto.getUserName(), userDto.getEmail(), userDto.getUserPhone(), userDto.getPassword(), passengerDto.getPassengerNum(), passengerDto.getPassengerName(), passengerDto.getPassengerAge(), passengerDto.getPassengerUIN(), passengerDto.getLuggage(), scheduleFlightDto.getScheduleflightId(), scheduleFlightDto.getAvailableSeats(), scheduleFlightDto.getScheduleId(), scheduleFlightDto.getFlightNumber());
		return response;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<BookingDto> allBookings(){
		List<Booking>list= service.viewAllBookings();
		List<BookingDto>response = new ArrayList<>();
		for(Booking booking:list) {
			UserDto userDto = findUserDetailsByUserId(booking.getUserId());
			PassengerDto passengerDto = findPassengerDetailsByPassengerNum(booking.getPassengerNum());
			ScheduledFlightDto scheduleFlightDto = findScheduledFlightById(booking.getScheduleFlightId());
			BookingDto dto = util.bookingDto(booking, userDto.getUserId(), userDto.getUserType(), userDto.getUserName(), userDto.getEmail(), userDto.getUserPhone(), userDto.getPassword(), passengerDto.getPassengerNum(), passengerDto.getPassengerName(), passengerDto.getPassengerAge(), passengerDto.getPassengerUIN(), passengerDto.getLuggage(), scheduleFlightDto.getScheduleflightId(), scheduleFlightDto.getAvailableSeats(), scheduleFlightDto.getScheduleId(), scheduleFlightDto.getFlightNumber());
			response.add(dto);
		}
		return response;
	}
	
	@DeleteMapping("/delete/{bookingId}")
	public void deleteBooking(@PathVariable("bookingId")BigInteger bookingId) {
		service.deleteBooking(bookingId);
	}

	private ScheduledFlightDto findScheduledFlightById(BigInteger scheduleFlightId) {
		String url = "http://scheduledflightmodule/scheduledflights/get/"+scheduleFlightId;
		ScheduledFlightDto dto = restTemplate.getForObject(url, ScheduledFlightDto.class);
		return dto;
	}

	private PassengerDto findPassengerDetailsByPassengerNum(BigInteger passengerNum) {
		String url = "http://passengermodule/passengers/get/"+passengerNum;
		PassengerDto dto = restTemplate.getForObject(url, PassengerDto.class);
		return dto;
	}

	private UserDto findUserDetailsByUserId(Integer userId) {
		String url = "http://usermodule/users/get/"+userId;
		UserDto dto = restTemplate.getForObject(url, UserDto.class);
		return dto;
	}

}