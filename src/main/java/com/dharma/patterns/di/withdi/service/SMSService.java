package com.dharma.patterns.di.withdi.service;

public class SMSService implements Service {

	@Override
	public void send(String msg, String rec) {
		System.out.println("SMS sent to "+rec+ " with Message="+msg);
	}

}
