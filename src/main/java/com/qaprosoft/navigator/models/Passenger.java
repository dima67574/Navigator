package com.qaprosoft.navigator.models;

public class Passenger extends Person{
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
		return "Passenger [passport=" + passport + ", getName()=" + getName() + ", getSecondName()=" + getSecondName()
				+ "]";
	}
	
	
	

}
