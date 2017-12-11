package com.spring.tutorials.aop;

// Class that contains actual business logic
public class Ay {

	public void main(int age) {
		System.out.println("Actual business logic");
		if (age < 18) {
			throw new ArithmeticException("Not a valid age");
		} else {
			System.out.println("Eligible for voting..");
		}
	}
}
