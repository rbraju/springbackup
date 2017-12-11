package com.spring.di.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application.context.bean.autowire.xml");
		
		Axsd a1 = context.getBean("a", Axsd.class);
		a1.display();
	}
}
