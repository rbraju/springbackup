package com.spring.di.factory.type2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrintableTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application.context.bean.factory.xml");
		Printable p = (Printable) ctx.getBean("p");
		p.print();
	}
}
