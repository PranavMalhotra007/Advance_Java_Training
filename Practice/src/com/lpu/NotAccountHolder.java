package com.lpu;

public class NotAccountHolder {
	public static void main(String[]args) {
		Account a = new Account();
		System.out.println(a.getAmt((short)0000));
		a.withdraw((short)0000, 3000);
		System.out.println(a.getAmt((short)0000));
	}
}
