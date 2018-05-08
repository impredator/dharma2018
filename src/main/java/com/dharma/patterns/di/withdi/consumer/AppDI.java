package com.dharma.patterns.di.withdi.consumer;

import com.dharma.patterns.di.withdi.service.Service;

public class AppDI implements Consumer{

	private Service service;

	public AppDI(Service svc){
		this.service=svc;
	}

	public AppDI(){}

	public void setService(Service service) {
		this.service = service;
	}

	@Override
	public void process(String msg, String rec){
		//extra msg logic
		this.service.send(msg, rec);
	}

}
