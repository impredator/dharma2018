package com.dharma.java8.functionalinterface;

import java.util.function.Consumer;

public class BasicConsumer {
    public static void main(String[] args) {
        Consumer<String> c = (x) -> System.out.println(x.toLowerCase());
        c.accept("ashton");

        Consumer<String> c2 = (x) -> System.out.println(x.toLowerCase());
        c2.andThen(c2).accept("ashton");
    }
}
