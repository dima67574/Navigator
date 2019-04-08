package com.qaprosoft.navigator.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Trip extends AbstractModel {
	@JsonIgnore
	private Passenger passenger;
	private Distance distance;
	public Trip() {}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Distance getDistance() {
		return distance;
	}
	public void setDistance(Distance distance) {
		this.distance = distance;
	}
	@Override
	public String toString() {
		return "Trip [passenger=" + passenger + ", distance=" + distance + "]";
	}	
}
