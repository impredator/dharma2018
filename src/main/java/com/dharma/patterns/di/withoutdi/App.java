package com.dharma.patterns.di.withoutdi;

public class App {

	private EmailService email = new EmailService();

	public void processMessages(String msg, String rec){
		//extra msg logic
		this.email.sendEmail(msg, rec);
	}
}
