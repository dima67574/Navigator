package com.qaprosoft.navigator;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.qaprosoft.navigator.algorithm.DijkstraAlgorithm;
import com.qaprosoft.navigator.algorithm.JacksonParser;
import com.qaprosoft.navigator.dao.IDistanceDao;
import com.qaprosoft.navigator.dao.IPassengerDao;
import com.qaprosoft.navigator.dao.ITripDao;
import com.qaprosoft.navigator.models.Distance;
import com.qaprosoft.navigator.models.Passenger;
import com.qaprosoft.navigator.models.Stop;
import com.qaprosoft.navigator.models.Trip;

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
	     	IPassengerDao p = s.getMapper(IPassengerDao.class); 
 	        Passenger passenger = new Passenger();
 	        passenger=p.getByName("Bruce", "Harvey");
 	       Trip trip = new Trip();

	        ITripDao tr = s.getMapper(ITripDao.class);
	         
	         List<Distance> d = c.getAll();
	         
	         DijkstraAlgorithm g = new DijkstraAlgorithm(d);
	         g.dijkstra("01-2");
	        g.printPath("02-8");
	        List <Stop> r = new ArrayList<Stop>();
	        r= g.printPath("02-8"); 
	        List <Trip> trips = new ArrayList<Trip>();
	        
	       
	        
	        
	        
	      int i = r.size();
	      int n = i-1;
	      int k = i-1;
	      for (Stop a: r) {
	    	  if(n>=0 && k>0){
	    		 r.get(k);
		    	 r.get(n);
		    	 n--;
		    	 k--;
		    	 }
	    	  for (Stop a1: r) {
		    	  if(k>0){
		    		 r.get(k);
			    	 k--;
			    	 }
	    	
	    	 Distance dis = c.getByStop(a.getId(),a1.getId());
	    	 if(dis!=null) {
	 	        trip.setPassenger(passenger);
	 	        trip.setDistance(dis); 
	 	        tr.insert(trip);
	 	        trips.add(trip);
	 	        s.commit();
	    	 
	    	 }
	      }
	      }
	      
	      JacksonParser.toJSON(trips);
	      
	      } catch (IOException e) {
	          log.error(e);
	      }
	     
      
	     }
	     
}