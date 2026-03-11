package com.lpu;

public class Account {
	int id = 1;
	private double amt = 600000;
	private short pin = 3030;
	public double getAmt(short pin) {
		if(pin == this.pin) {
		return amt;
		}
		return -1;
	}
	public void withdraw(short pin, double money) {
		if(pin == this.pin) {
			amt -=money;
			System.out.println("Amount withdrwn successfully");
		}
		else {
			System.out.println("Wrong pin");
		}
	}
	public void deposit(short pin, double money) {
		if(pin == this.pin) {
			amt +=money;
			System.out.println("Amount deposit successfully");
		}
		else {
			System.out.println("Wrong pin");
		}
	}
}
