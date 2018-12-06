package com.dharma.java8.functionalinterface;

import java.util.function.Supplier;

public class BasicSupplier {
    public static void main(String[] args) {
        Supplier<String> i = () -> "ashton";

        System.out.println(i.get());
    }
}
