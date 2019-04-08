package com.qaprosoft.navigator.algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qaprosoft.navigator.models.Stop;

public class Vertex implements Comparable<Vertex>{
	private static final Logger log = LogManager.getLogger(Vertex.class);
	public  int id;
    public int dist = Integer.MAX_VALUE; 
    public Vertex previous = null;
    public final Map<Vertex, Integer> neighbours = new HashMap<Vertex, Integer>();
    public Vertex(int id) {
       this.id = id;
    }
    public List<Stop> printPath(List <Stop> s) {
    int n ;
       if (this == this.previous) {
    	  n = this.id;
    	  Stop s1 = new Stop();
    	  s1.setId(n);
    	  s.add(s1);
       } else if (this.previous == null) {
      	 log.info("(unreached)"+ this.id);
       } else {
          this.previous.printPath(s);
          n = this.id;
          Stop s2 = new Stop();
     	  s2.setId(n);
     	  s.add(s2);
       }
	return s;	
    }
    public int compareTo(Vertex other) {
       return Integer.compare(dist, other.dist);
    }
 }
