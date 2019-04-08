package com.qaprosoft.navigator.dao;

import java.util.List;

import com.qaprosoft.navigator.models.Trip;

public interface ITripDao extends IDao <Trip> {
	List<Trip> getAll();

}
