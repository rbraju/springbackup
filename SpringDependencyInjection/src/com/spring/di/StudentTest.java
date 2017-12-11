package com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("application.context.bean.xml");
		Student s = (Student) context.getBean("student");
		s.display();
	}
}
