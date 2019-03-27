package com.qaprosoft.navigator.models;

public class Trip extends AbstractModel {
	private Passenger passenger;
	private Transport transport;
	public Trip() {}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Transport getTransport() {
		return transport;
	}
	public void setTransport(Transport transport) {
		this.transport = transport;
	}
}
