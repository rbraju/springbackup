package com.spring.tutorials.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AyTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app.ctx.bean.aop.xml");
		Ay ay1 = (Ay) context.getBean("proxy", Ay.class);
		try {
			ay1.main(19);
		} catch(Exception ex) {
			System.out.println("Exception occurred");
		}
	}
}
