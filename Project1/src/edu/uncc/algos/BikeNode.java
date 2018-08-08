package edu.uncc.algos;

public class BikeNode {
	
	private Bike bike;
	private BikeNode next;
	
	public BikeNode(Bike bike) {
		super();
		this.bike = bike;
		this.next = null;
	}

	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}

	public BikeNode getNext() {
		return next;
	}

	public void setNext(BikeNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "BikeNode [bike=" + bike + ", next=" + next + "]";
	}

	
	

}
