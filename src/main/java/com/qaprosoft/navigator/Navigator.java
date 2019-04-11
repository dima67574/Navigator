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

public class Navigator {
	private final static Logger log= Logger.getLogger(Navigator.class);
	private String from;
	private String to;
	public Navigator() {}
	public void getInf(String from, String to) {
		Reader reader = null;
	     try {
	    	 reader = Resources.getResourceAsReader("mybatis_config.xml"); 
	         SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
	         SqlSession session = factory.openSession();
	         IDistanceDao distance = session.getMapper(IDistanceDao.class);
	     	 IPassengerDao p = session.getMapper(IPassengerDao.class); 
	         Passenger passenger = new Passenger();
	         passenger=p.getByName("Bruce", "Harvey");
	        
	         ITripDao tr = session.getMapper(ITripDao.class);
	         List<Trip> trips=new ArrayList<Trip>();
	         List<Distance> distances = distance.getAll();
	         DijkstraAlgorithm g = new DijkstraAlgorithm(distances);
	         g.dijkstra(from);
	         List <Stop> r = new ArrayList<Stop>();
	         r= g.printPath(to); 
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
	    	 Distance dis = distance.getByStop(a.getId(),a1.getId());
		    	 if(dis!=null) {
		    		Trip trip = new Trip();
		 	        trip.setPassenger(passenger);
		 	        trip.setDistance(dis); 
		 	        tr.insert(trip);
		 	        session.commit();
		 	        trips.add(trip);
		 	       
		 	        
		    	 }
	    	  }
	      }
	      JacksonParser.toJSON(trips);
	    } catch (IOException e) {
	          log.error(e);
	    }
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}     
}
