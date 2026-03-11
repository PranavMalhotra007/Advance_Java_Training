package com.lpu;
public class Student {
	private String n;
	private long p;
	private String e;
	public String getN() {
		return n;
	}
	public void setN(String n) {
		this.n = n;
	}
	public long getP() {
		return p;
	}
	public void setP(long p) {
		this.p = p;
	}
	
	public Student(String n, long p, String e) {
		super();
		this.n = n;
		this.p = p;
		this.e = e;
	}
	public String getE() {
		return e;
	}
	public void setE(String e) {
		this.e = e;
	}
	public Student() {
		super();
	}
	
}
