package com.dxctraining.booking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralisedExceptionHandler {

	 @ExceptionHandler(BookingNotFoundException.class)
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    public String handleFlightNotFound(BookingNotFoundException e){
	        System.out.println("inside handle booking not found exception");
	        String msg=e.getMessage();
	        return msg;
	    }

	    @ExceptionHandler(InvalidArgumentException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public String handleInvalidArgument(InvalidArgumentException e){
	        System.out.println("inside handle invalid argument exception");
	        return e.getMessage();
	    }
	   
}