package com.spring.integration.linkmodule;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

public class KeywordApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/linkModuleConfig.xml");

		// Get the reference to the message channel
		MessageChannel channel = context.getBean("inputChannel", MessageChannel.class);

		Keyword keyword = new Keyword();
		keyword.setKeyword("iphone");
		keyword.setPopScore(260483);

		Message<Keyword> message = MessageBuilder.withPayload(keyword).build();
		channel.send(message);
	}
}