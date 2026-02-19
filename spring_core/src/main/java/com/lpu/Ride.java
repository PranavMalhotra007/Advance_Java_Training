package com.lpu;

public class Ride {
	Vehicle v;
	public void startRide() {
		v.start();
	}
	public static void main(String[]args) {
		Ride ride = new Ride();
		ride.v =new Bike();
		ride.startRide();
		ride.v =new Car();
		ride.startRide();
	}
}
