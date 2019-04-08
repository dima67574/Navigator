package com.qaprosoft.navigator.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Stop extends AbstractModel{
	private String number;
	@JsonIgnore 
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
