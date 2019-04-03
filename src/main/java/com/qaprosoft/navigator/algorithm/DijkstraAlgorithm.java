package com.qaprosoft.navigator.algorithm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qaprosoft.navigator.models.Distance;
import com.qaprosoft.navigator.models.Stop;
public class DijkstraAlgorithm {	
	   private static final Logger log = LogManager.getLogger(DijkstraAlgorithm.class);
	   private static Map<String, Vertex> graph;	  
	   public static class Vertex implements Comparable<Vertex> {
	      public final String name;
	      public int dist = Integer.MAX_VALUE; 
	      public Vertex previous = null;
	      public final Map<Vertex, Integer> neighbours = new HashMap<Vertex, Integer>();
	  
	      public Vertex(String name) {
	         this.name = name;
	      }
	  
	      private void printPath() {
	    	 
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
	   
	   public DijkstraAlgorithm(List<Distance> edges )
	   {
		   graph = new HashMap<>((edges.size()));
		   for (Distance e : edges) {			   
		         if (!graph.containsKey(e.getFirstStop().getNumber())) graph.put(e.getFirstStop().getNumber(), new Vertex(e.getFirstStop().getNumber()));
		         if (!graph.containsKey(e.getLastStop().getNumber())) graph.put(e.getLastStop().getNumber(), new Vertex(e.getLastStop().getNumber()));
		   
		      }
		  
		      for (Distance e : edges) {
		         graph.get(e.getFirstStop().getNumber()).neighbours.put(graph.get(e.getLastStop().getNumber()), e.getDistance());
		         
		  
		      }
		   }
	   
	   public void dijkstra(String startName) {
	      if (!graph.containsKey(startName)) {
	    	  log.error("Graph doesn't contain start vertex"+ startName);
	         return;
	      }
	      final Vertex source = graph.get(startName);
	      NavigableSet<Vertex> q = new TreeSet<Vertex>();
	      for (Vertex v : graph.values()) {
	         v.previous = v == source ? source : null;
	         v.dist = v == source ? 0 : Integer.MAX_VALUE;
	         q.add(v);
	         
	      }
	  
	      dijkstra(q);
	   }
	   private void dijkstra(final NavigableSet<Vertex> q) {      
	      Vertex u, v;
	      while (!q.isEmpty()) {
	  
	         u = q.pollFirst();
	         if (u.dist == Integer.MAX_VALUE) break;
	         for (Map.Entry<Vertex, Integer> a : u.neighbours.entrySet()) {
	            v = a.getKey(); 
	  
	            final int alternateDist = u.dist + a.getValue();
	            if (alternateDist < v.dist) { 
	               q.remove(v);
	               v.dist = alternateDist;
	               v.previous = u;
	               q.add(v);
	            } 
	         }
	      }
	   }
	  
	   public void printPath(String endName) {
	      if (!graph.containsKey(endName)) {
	    	  log.error("Graph doesn't contain end vertex"+ endName);
	         return;
	      }
	  
	      graph.get(endName).printPath();
	   }
	  
	}