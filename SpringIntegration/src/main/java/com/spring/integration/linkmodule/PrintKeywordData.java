package com.spring.integration.linkmodule;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

public class PrintKeywordData {

	private Keyword keyword = null;

	@ServiceActivator
	public void printData(Message<Keyword> message) {
		keyword = (Keyword) message.getPayload();
		System.out.println(keyword.toString());
		updateKeyword(keyword);
		System.out.println(keyword.toString());
	}

	public void updateKeyword(Keyword key) {
		key.setKeyword("updated keyword");
		key.setPopScore(-1);
	}
}
