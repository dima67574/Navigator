package com.qaprosoft.navigator.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Passenger extends Person{
	@JsonIgnore 
	private String passport;
	public Passenger() {}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	@Override
	public String toString() {
		return "Passenger [passport=" + passport + ", name=" + getName() + ", secondName=" + getSecondName()
				+ "]";
	}
	
	
	

}
