package com.spring.integration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

public class HelloApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/helloAppConfig.xml");

		// Get the reference to the message channel
		MessageChannel channel = context.getBean("inputChannel", MessageChannel.class);

		// Create a message with content 'World'
		Message<String> message = MessageBuilder.withPayload("World").build();

		// Send the message to the input channel
		channel.send(message);
	}
}