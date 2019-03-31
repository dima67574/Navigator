package com.qaprosoft.navigator.models;

public class Driver extends Person {
	private License license;
	public Driver() {}
	public License getLicense() {
		return license;
	}
	public void setLicense(License license) {
		this.license = license;
	}
	@Override
	public String toString() {
		return "Driver [id=" + getId()+ "name=" + getName() + ", secondName=" + getSecondName() +" license=" + license +  "]";
	}

	
	
}
