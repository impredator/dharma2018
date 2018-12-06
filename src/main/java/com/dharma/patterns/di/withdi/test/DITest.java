package com.dharma.patterns.di.withdi.test;

import com.dharma.patterns.di.withdi.consumer.Consumer;
import com.dharma.patterns.di.withdi.injector.EmailServiceInjector;
import com.dharma.patterns.di.withdi.injector.SMSServiceInjector;
import com.dharma.patterns.di.withdi.injector.ServiceInjector;

public class DITest {

	public static void main(String[] args) {
		String msg = "Hi Ashton";
		String email = "ashton@me.com";
		String phone = "8888888888";
		ServiceInjector injector = null;
		Consumer app = null;

		//Send email
		injector = new EmailServiceInjector();
		app = injector.getConsumer();
		app.process(msg, email);

		//Send SMS
		injector = new SMSServiceInjector();
		app = injector.getConsumer();
		app.process(msg, phone);
	}

}
