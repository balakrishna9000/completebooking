package com.dxctraining.booking.exceptions;

public class BookingNotFoundException extends RuntimeException{

    public BookingNotFoundException(String msg){
        super(msg);
    }
 
}
