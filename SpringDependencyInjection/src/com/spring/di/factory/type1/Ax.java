package com.spring.di.factory.type1;

public class Ax {

	private static final Ax ax = new Ax();

	private Ax() {
		System.out.println("Private Constructor");
	}

	// Type 1 - Static factory method that returns its own class
	public static Ax getAx() {
		System.out.println("Factory Method");
		return ax;
	}

	public void msg() {
		System.out.println("Hello User!");
	}

	static {
		System.out.println("Static block");
	}
}
