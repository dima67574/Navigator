package com.qaprosoft.navigator.models;

public class City extends AbstractModel {
	private String city;
	private Country country;
	public City() {}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "City [city=" + city + ", country=" + country + "]";
	}
	
	
}
