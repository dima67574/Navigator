package com.qaprosoft.navigator;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.qaprosoft.navigator.dao.ITripDao;
import com.qaprosoft.navigator.models.Trip;

public class Runner {

	public static void main(String[] args) {
		Reader reader = null; 
		try { 
			reader = Resources.getResourceAsReader("mybatis_config.xml"); 
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader); 
			SqlSession s = factory.openSession(); 
				
			ITripDao tr = s.getMapper(ITripDao.class); 
			Trip trip= tr.getById(1); 
			System.out.println(trip.toString()); 
			s.close();
		} catch (IOException e) { 
			e.printStackTrace(); 
		}
	}

}
