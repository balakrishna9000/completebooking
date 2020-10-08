package com.dxctraining.booking.dto;

import java.math.BigInteger;

	public class ScheduledFlightDto {
		
		private BigInteger scheduleflightId;
		
		private Integer availableSeats;
		
		private Integer scheduleId;
		
		private BigInteger flightNumber;

		
		public BigInteger getScheduleflightId() {
			return scheduleflightId;
		}

		public void setScheduleflightId(BigInteger scheduleflightId) {
			this.scheduleflightId = scheduleflightId;
		}

		public Integer getAvailableSeats() {
			return availableSeats;
		}

		public void setAvailableSeats(Integer availableSeats) {
			this.availableSeats = availableSeats;
		}

		public Integer getScheduleId() {
			return scheduleId;
		}

		public void setScheduleId(Integer scheduleId) {
			this.scheduleId = scheduleId;
		}

		public BigInteger getFlightNumber() {
			return flightNumber;
		}

		public void setFlightNumber(BigInteger flightNumber) {
			this.flightNumber = flightNumber;
		}

	}

