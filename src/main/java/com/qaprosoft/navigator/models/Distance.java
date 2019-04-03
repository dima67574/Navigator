package com.qaprosoft.navigator.models;

public class Distance extends AbstractModel {
	public int distance;	
	private Stop firstStop;
	private Stop lastStop;
	public String firstStop1;
	public String lastStop1;
	
	private Transport transport;
	public Distance() {}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public Stop getFirstStop() {
		return firstStop;
	}
	public void setFirstStop(Stop firstStop) {
		this.firstStop = firstStop;
	}
	public Stop getLastStop() {
		return lastStop;
	}
	public void setLastStop(Stop lastStop) {
		this.lastStop = lastStop;
	}
	
	public Transport getTransport() {
		return transport;
	}
	public void setTransport(Transport transport) {
		this.transport = transport;
	}
	
	public String getFirstStop1() {
		return firstStop1;
	}
	public void setFirstStop1(String firstStop1) {
		this.firstStop1 = firstStop1;
	}
	public String getLastStop1() {
		return lastStop1;
	}
	public void setLastStop1(String lastStop1) {
		this.lastStop1 = lastStop1;
	}
	@Override
	public String toString() {
		return "Distance [distance=" + distance + ", firstStop=" + firstStop1 + ", lastStop=" + lastStop1 + ", transport-"
				+ transport + "]";
	}
	
	
}
