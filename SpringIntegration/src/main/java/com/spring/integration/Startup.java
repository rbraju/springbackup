package com.spring.integration;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

public class Startup {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/si-components.xml");
		MessageChannel channel = context.getBean("messageChannel", MessageChannel.class);

		Message<String> message1 = MessageBuilder.withPayload("Hello Rajesh!").build();
		Message<String> message2 = MessageBuilder.withPayload("Hello xyz !").build();

		System.out.println("Sending message 1");
		channel.send(message1);

		System.out.println("Sending message 2");
		channel.send(message2);
		
		System.out.println("Done sending messages");
	}
}
