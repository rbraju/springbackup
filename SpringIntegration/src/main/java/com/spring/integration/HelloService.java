package com.spring.integration;

import org.springframework.stereotype.Component;

@Component
public class HelloService {

	public String sayHello(String message) {
		return "Hello " + message + "!";
	}
}
