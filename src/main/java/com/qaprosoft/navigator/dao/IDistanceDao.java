package com.qaprosoft.navigator.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qaprosoft.navigator.models.Distance;

public interface IDistanceDao extends IDao <Distance>{

	List<Distance> getAll();
	Distance getByStop(@Param("firstStopId") int key, @Param("lastStopId") int userId);

}
