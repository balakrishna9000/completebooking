package com.dxctraining.booking.entities;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Booking {
	@Id
	@GeneratedValue
	private  BigInteger bookingId;
	private Integer userId;
	private Date bookingDate;
	private double ticketCost;
	private BigInteger passengerNum;
	private BigInteger scheduleFlightId;
	
	public Booking() {
		
	}

	public Booking(Integer userId,Date bookingDate, double ticketCost,BigInteger passengerNum,BigInteger scheduleFlightId) {
		this.userId=userId;
		this.bookingDate=bookingDate;
		this.ticketCost=ticketCost;
		this.passengerNum=passengerNum;
		this.scheduleFlightId=scheduleFlightId;

	}

	public BigInteger getPassengerNum() {
		return passengerNum;
	}

	public void setPassengerNum(BigInteger passengerNum) {
		this.passengerNum = passengerNum;
	}

	public BigInteger getScheduleFlightId() {
		return scheduleFlightId;
	}

	public void setScheduleFlightId(BigInteger scheduleFlightId) {
		this.scheduleFlightId = scheduleFlightId;
	}

	public BigInteger getBookingId() {
		return bookingId;
	}

	public void setBookingId(BigInteger bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public double getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}
	@Override
	public int hashCode() {
		int hash=bookingId.hashCode();
		return hash;
	}
	@Override
	public boolean equals(Object arg) {
		if(arg==this) {
			return true;
		}
		
	   if(arg==null || !(arg instanceof Booking) ) {
			return false;
	   }
		
	    Booking that=(Booking)arg;	
		boolean equalResult=this.bookingId.equals(that.bookingId);
		return equalResult;
	}
	
	}
