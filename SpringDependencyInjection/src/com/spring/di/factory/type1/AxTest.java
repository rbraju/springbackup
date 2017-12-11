package com.spring.di.factory.type1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AxTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("application.context.bean.factory.xml");

		Ax a = (Ax) ctx.getBean("a1");

		a.msg();
	}
}
