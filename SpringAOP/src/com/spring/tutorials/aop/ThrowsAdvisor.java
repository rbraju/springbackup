package com.spring.tutorials.aop;

import org.springframework.aop.ThrowsAdvice;

public class ThrowsAdvisor implements ThrowsAdvice {

	public void afterThrowing(Exception ex) {
		System.out.println("$$$ Exception occurred");
	}
}
