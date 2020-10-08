package com.dxctraining.booking.dto;

import java.math.BigInteger;

public class PassengerDto {
	private BigInteger passengerNum;
	private String passengerName;
	private Integer passengerAge;
	private BigInteger passengerUIN;
	private double luggage;
	
	public PassengerDto(BigInteger passengerNum,String passengerName,Integer passengerAge,BigInteger passengerUIN,double luggage) {
		this.passengerNum=passengerNum;
		this.passengerName=passengerName;
		this.passengerUIN=passengerUIN;
		this.passengerAge=passengerAge;
		this.luggage=luggage;
	}

	public BigInteger getPassengerNum() {
		return passengerNum;
	}

	public void setPassengerNum(BigInteger passengerNum) {
		this.passengerNum = passengerNum;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Integer getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}

	public BigInteger getPassengerUIN() {
		return passengerUIN;
	}

	public void setPassengerUIN(BigInteger passengerUIN) {
		this.passengerUIN = passengerUIN;
	}

	public double getLuggage() {
		return luggage;
	}

	public void setLuggage(double luggage) {
		this.luggage = luggage;
	}
}

