package com.qaprosoft.navigator.models;

public class Transport extends AbstractModel {
	private String number;
	private String fuel;
	private Stop firstStop;
	private Stop lastStop;
	private Driver driver;
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
	public Stop getFirstStop() {
		return firstStop;
	}
	public void setFirstStop(Stop firstStop) {
		this.firstStop = firstStop;
	}
	public Stop getLastStop() {
		return lastStop;
	}
	public void setLastStop(Stop lastStop) {
		this.lastStop = lastStop;
	}
	public Driver getBusDriver() {
		return driver;
	}
	public void setBusDriver(Driver driver) {
		this.driver = driver;
	}
}
