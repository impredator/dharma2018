package com.dharma.junit5;

import com.dharma.patterns.di.withdi.consumer.AppDI;
import com.dharma.patterns.di.withdi.consumer.Consumer;
import com.dharma.patterns.di.withdi.injector.ServiceInjector;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class DITest {

    private static ServiceInjector injector;

    @BeforeAll
    static void init() {
        injector =
                () -> new AppDI(
                        (msg, rec) -> System.out.println("Mock Message Service"));
    }

    @Test
    void test() {
        Consumer consumer = injector.getConsumer();
        consumer.process("Hi Ashton", "ashton@me.com");
    }

    @AfterAll
    static void tear() {
        injector = null;
    }

}
