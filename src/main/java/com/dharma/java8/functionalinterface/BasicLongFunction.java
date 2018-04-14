package com.dharma.java8.functionalinterface;

import java.util.function.LongFunction;

public class BasicLongFunction {

    public static void main(String[] args) {
        //long argument, return any type
        LongFunction<String> i = (l) -> Long.toString(l);
        System.out.println(i.apply(Long.MAX_VALUE));
    }
}