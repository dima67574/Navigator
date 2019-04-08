package com.qaprosoft.navigator.models;

public class Stop extends AbstractModel{
	private String number;
	private City city;
	
	public Stop() {}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Stop [number=" + number + ", city=" + city +  "]";
	}
	


	
}
