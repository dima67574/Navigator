package com.qaprosoft.navigator.algorithm;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Vertex implements Comparable<Vertex>{
	private static final Logger log = LogManager.getLogger(Vertex.class);
	public final String name;
    public int dist = Integer.MAX_VALUE; 
    public Vertex previous = null;
    public final Map<Vertex, Integer> neighbours = new HashMap<Vertex, Integer>();

    public Vertex(String name) {
       this.name = name;
    }
    public void printPath() {
       if (this == this.previous) {
      	 log.info(this.name);
       } else if (this.previous == null) {
      	 log.info("(unreached)"+ this.name);
       } else {
          this.previous.printPath();
          log.info("->"+ this.name+" distance "+this.dist);
       }	
    }
    public int compareTo(Vertex other) {
       return Integer.compare(dist, other.dist);
    }
 }

