package com.qaprosoft.navigator;
import com.qaprosoft.navigator.algorithm.DijkstraAlgorithm;
import com.qaprosoft.navigator.services.DistanceService;

public class Runner {	
   
  
   public static void main(String[] args) {
	  
	  DistanceService DistanceService=new DistanceService();      
      DijkstraAlgorithm g = new DijkstraAlgorithm(DistanceService.getAll());
      g.dijkstra("1");
      g.printPath("14");
      
   }
}