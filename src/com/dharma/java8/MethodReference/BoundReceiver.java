package com.dharma.java8.MethodReference;

import java.util.function.Supplier;

public class BoundReceiver {
    //bound receiver = instance::MethodName
    public static void main(String[] argv) {
        Supplier<Integer> supplier = () -> "ashton".length();
        System.out.println(supplier.get());

        Supplier<String> supplier1 = "ji"::toString;
        System.out.println(supplier1.get());
    }
}
