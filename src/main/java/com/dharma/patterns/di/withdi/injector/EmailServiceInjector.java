package com.dharma.patterns.di.withdi.injector;

import com.dharma.patterns.di.withdi.consumer.AppDI;
import com.dharma.patterns.di.withdi.consumer.Consumer;
import com.dharma.patterns.di.withdi.service.EmailService;

public class EmailServiceInjector implements ServiceInjector {

	@Override
	public Consumer getConsumer() {
		AppDI app = new AppDI();
		app.setService(new EmailService());
		return app;
	}

}
