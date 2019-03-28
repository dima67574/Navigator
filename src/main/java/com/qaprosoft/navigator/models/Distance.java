package com.qaprosoft.navigator.models;

public class Distance extends AbstractModel {
	private int distance;
	private Stop firstStop;
	private Stop lastStop;
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
	@Override
	public String toString() {
		return "Distance [distance=" + distance + ", firstStop=" + firstStop + ", lastStop=" + lastStop + "]";
	}
	
	
}
