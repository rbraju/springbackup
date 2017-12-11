package com.spring.jdbc.template;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("application.context.bean.xml");
		UserDAO userDAO = (UserDAO) context.getBean("userDAOBean");
		
		User user = userDAO.getUserByUserid(1001);
		System.out.println(user.toString());
	}
}
