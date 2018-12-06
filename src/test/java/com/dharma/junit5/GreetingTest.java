package com.dharma.junit5;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
class GreetingTest {

    @Test
    void TestSayHello() {
        Greeting greeting = new Greeting();
        assertEquals(greeting.sayHello(), "Hi dharma");
    }

}
