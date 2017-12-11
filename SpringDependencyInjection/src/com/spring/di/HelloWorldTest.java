package com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("application.context.bean.xml");

		HelloWorld hw = (HelloWorld) context.getBean("helloWorld");

		System.out.println(hw.getMessage());
	
	}
}
