package com.lpu;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle{

	@Override
	public void run() {
		System.out.println("Bike is started....");
		
	}

	@Override
	public String toString() {
		return "Bike []";
	}

}
