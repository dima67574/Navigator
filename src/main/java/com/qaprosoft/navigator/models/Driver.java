package com.qaprosoft.navigator.models;

public class Driver extends Person {
	private License licence;
	public Driver() {}
	public License getLicence() {
		return licence;
	}
	public void setLicence(License licence) {
		this.licence = licence;
	}
}
