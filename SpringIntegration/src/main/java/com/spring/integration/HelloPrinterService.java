package com.spring.integration;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class HelloPrinterService {

	@ServiceActivator
	public void printValue(String value) {
		System.out.println(value);
	}
}
