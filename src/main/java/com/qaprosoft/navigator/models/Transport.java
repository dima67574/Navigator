package com.qaprosoft.navigator.models;

public class Transport extends AbstractModel {
	private String number;
	private String fuel;
	private Driver driver;
	private Type type;
	public Transport() {}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Transport [number=" + number + ", fuel=" + fuel +  "driver=" + driver + ", type=" + type + "]";
	}
	
	
	
	
	
}
