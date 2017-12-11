package com.spring.tutorials.aop.aspectj;

public class Operation {

	public void message() {
		System.out.println("Invoking message()");
	}

	public int xyz() {
		System.out.println("Invoking xyz()");
		return 3;
	}

	public int abc() {
		System.out.println("Invoking abc()");
		return 1;
	}
}
