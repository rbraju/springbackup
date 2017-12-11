package com.spring.di.autowire;

public class Axsd {

	private Bxsd b11;

	Axsd() {
		System.out.println("Created object for Axsd");
	}
	
	public Bxsd getB11() {
		return b11;
	}

	public void setB11(Bxsd b11) {
		this.b11 = b11;
	}
	
	public void print() {
		System.out.println("Hello Axsd");
	}
	
	public void display() {
		print();
		b11.print();
	}
}
