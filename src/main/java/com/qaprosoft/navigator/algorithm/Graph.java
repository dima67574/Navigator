package com.qaprosoft.navigator.algorithm;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
public class Graph {
		private static final Logger log = LogManager.getLogger(Graph.class);
	   private final Map<String, Vertex> graph; 
	   public static class Edge {
	      private final String v1, v2;
	      private final int dist;
	      public Edge(String v1, String v2, int dist) {
	         this.v1 = v1;
	         this.v2 = v2;
	         this.dist = dist;
	      }
	   }
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
	            log.info(" -> "+ this.name+this.dist);
	         }
	      }
	  
	      public int compareTo(Vertex other) {
	         return Integer.compare(dist, other.dist);
	      }
	   }
	   public Graph(Edge[] edges) {
	      graph = new HashMap<>(edges.length);
	      for (Edge e : edges) {
	         if (!graph.containsKey(e.v1)) graph.put(e.v1, new Vertex(e.v1));
	         if (!graph.containsKey(e.v2)) graph.put(e.v2, new Vertex(e.v2));
	      }
	  
	      for (Edge e : edges) {
	         graph.get(e.v1).neighbours.put(graph.get(e.v2), e.dist);
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