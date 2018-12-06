package com.dharma.patterns.di.withdi.service;

public class EmailService implements Service {

	@Override
	public void send(String msg, String rec) {
		System.out.println("Email sent to "+rec+ " with Message="+msg);
	}

}
