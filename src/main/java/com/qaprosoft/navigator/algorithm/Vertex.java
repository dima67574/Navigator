package com.qaprosoft.navigator.algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qaprosoft.navigator.models.Stop;

public class Vertex implements Comparable<Vertex>{
	private static final Logger log = LogManager.getLogger(Vertex.class);
	private  int id;
	private int dist = Integer.MAX_VALUE; 
	private Vertex previous = null;
	private final Map<Vertex, Integer> neighbours = new HashMap<Vertex, Integer>();
    public Vertex(int id) {
       this.id = id;
    }
    public List<Stop> printPath(List <Stop> s) {
    int n ;
       if (this == this.getPrevious()) {
    	  n = this.id;
    	  Stop s1 = new Stop();
    	  s1.setId(n);
    	  s.add(s1);
       } else if (this.getPrevious() == null) {
      	 log.info("(unreached)"+ this.id);
       } else {
          this.getPrevious().printPath(s);
          n = this.id;
          Stop s2 = new Stop();
     	  s2.setId(n);
     	  s.add(s2);
       }
	return s;	
    }
    public int compareTo(Vertex other) {
       return Integer.compare(getDist(), other.getDist());
    }
	public Map<Vertex, Integer> getNeighbours() {
		return neighbours;
	}
	public Vertex getPrevious() {
		return previous;
	}
	public void setPrevious(Vertex previous) {
		this.previous = previous;
	}
	public int getDist() {
		return dist;
	}
	public void setDist(int dist) {
		this.dist = dist;
	}
	
	
 }
