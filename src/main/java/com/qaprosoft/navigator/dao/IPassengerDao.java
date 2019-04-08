package com.qaprosoft.navigator.dao;

import org.apache.ibatis.annotations.Param;

import com.qaprosoft.navigator.models.Passenger;

public interface IPassengerDao extends IDao <Passenger> {
	Passenger getByName(@Param("name") String key, @Param("secondName") String userId);

}
