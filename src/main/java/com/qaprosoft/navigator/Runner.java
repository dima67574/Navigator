package com.qaprosoft.navigator;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.qaprosoft.navigator.algorithm.DijkstraAlgorithm;
import com.qaprosoft.navigator.dao.IDistanceDao;
import com.qaprosoft.navigator.models.Distance;

public class Runner {	
   
	private final static Logger log= Logger.getLogger(Runner.class);
    public static void main(String[] args) {
	  
	 /*DistanceService DistanceService=new DistanceService();      
      DijkstraAlgorithm g = new DijkstraAlgorithm(DistanceService.getAll());
      g.dijkstra("1");
      g.printPath("5");*/
      
	  Reader reader = null;
	     try {
	    	 reader = Resources.getResourceAsReader("mybatis_config.xml"); 
	         SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
	         SqlSession s = factory.openSession();
	         IDistanceDao c = s.getMapper(IDistanceDao.class);
	         List<Distance> d = c.getAll();
	         DijkstraAlgorithm g = new DijkstraAlgorithm(d);
	         g.dijkstra("01-2");
	         g.printPath("02-8");
	         
	         log.info(d.get(0).toString());
	      } catch (IOException e) {
	          log.error(e);
	      }
      
   }
}