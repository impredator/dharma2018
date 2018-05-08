package com.dharma.patterns.di.withdi.injector;

import com.dharma.patterns.di.withdi.consumer.AppDI;
import com.dharma.patterns.di.withdi.consumer.Consumer;
import com.dharma.patterns.di.withdi.service.SMSService;

public class SMSServiceInjector implements ServiceInjector {

    @Override
    public Consumer getConsumer() {
        return new AppDI(new SMSService());
    }

}
