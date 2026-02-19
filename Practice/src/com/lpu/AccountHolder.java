package com.lpu;

public class AccountHolder {
	public static void main(String[]args) {
		Account a = new Account();
		System.out.println(a.getAmt((short)3030));
		a.withdraw((short)3030, 3000);
		System.out.println(a.getAmt((short)3030));
	}
}
