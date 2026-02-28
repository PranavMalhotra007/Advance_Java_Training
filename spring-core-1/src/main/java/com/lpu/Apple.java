package com.lpu;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Apple implements Fruit {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Eating apple.....");
	}

	@Override
	public String toString() {
		return "Apple []";
	}
	
}
