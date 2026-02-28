package com.lpu;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
public class Car implements Vehicle{
	@Override
	public void run() {
		System.out.println("Car is running.....");
	}

	@Override
	public String toString() {
		return "Car []";
	}
	
}
