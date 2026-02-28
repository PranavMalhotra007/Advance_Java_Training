package com.lpu;

public class Food {
	private static Food f ;
	private Food() {
		
	}
	public static Food getFood() {
		if(f == null) {
			f= new Food();
		}
		return f;
	}
}
