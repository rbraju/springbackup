package com.spring.tutorials.aop.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OperationTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("app.ctx.bean.aop.aspectj.xml");
		Operation op = (Operation) context.getBean("operationBean");
		
		System.out.println("Calling message()");
		op.message();
		
		System.out.println("Calling xyz()");
		op.xyz();
		
		System.out.println("Calling abc()");
		op.abc();
	}
}
