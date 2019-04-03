package com.qaprosoft.navigator.dao;

import java.util.List;

import com.qaprosoft.navigator.models.Distance;

public interface IDistanceDao extends IDao <Distance>{

	List<Distance> getAll();

}
