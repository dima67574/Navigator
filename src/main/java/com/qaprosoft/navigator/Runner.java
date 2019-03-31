package com.qaprosoft.navigator;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.qaprosoft.navigator.dao.IDistanceDao;
import com.qaprosoft.navigator.models.Distance;

public class Runner {

	public static void main(String[] args) {
		Reader reader = null; 
		try { 
			reader = Resources.getResourceAsReader("mybatis_config.xml"); 
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader); 
			SqlSession s = factory.openSession(); 
				
			IDistanceDao dis = s.getMapper(IDistanceDao.class); 
			Distance distance= dis.getById(6); 
			System.out.println(distance.toString()); 
			s.close();
		} catch (IOException e) { 
			e.printStackTrace(); 
		}
	}

}
