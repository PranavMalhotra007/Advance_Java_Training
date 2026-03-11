package com.lpu;

import org.springframework.stereotype.Component;

@Component
public class Mango implements Fruit {

	@Override
	public String toString() {
		return "Mango []";
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Eating Mango.....");
	}
	
}
