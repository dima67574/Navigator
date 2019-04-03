package com.qaprosoft.navigator.services;

import java.util.List;

import com.qaprosoft.navigator.dao.IDistanceDao;
import com.qaprosoft.navigator.models.Distance;
import com.qaprosoft.navigator.mybatis.MyBatisConnection;

public class DistanceService implements IDistanceDao {
	private IDistanceDao distanceDao= MyBatisConnection.getInstance().getSqlSessionFactory().openSession().getMapper(IDistanceDao.class);
	@Override
	public void insert(Distance distance)  {		
			distanceDao.insert(distance);	
		
	}

	@Override
	public Distance getById(int id) {
		Distance distance = distanceDao.getById(id);		
		return distance;
	}

	@Override
	public void update(Distance distanceType) {
		distanceDao.update(distanceType);
		
	}


	@Override
	public void delete(Distance distance) {
		distanceDao.delete(distance);
		
	}
	@Override
	public List<Distance> getAll() {
		List<Distance> distance = distanceDao.getAll();		
		return distance;
	}
	

	

}
