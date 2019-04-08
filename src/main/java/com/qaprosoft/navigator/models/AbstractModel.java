package com.qaprosoft.navigator.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class AbstractModel {
	@JsonIgnore 
	private int id;
	public String toString() {
		return "id: "+ id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
