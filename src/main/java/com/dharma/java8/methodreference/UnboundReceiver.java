package com.dharma.java8.methodreference;

import java.util.function.Function;

public class UnboundReceiver {
    //unbound receiver = ClassName::instanceMethod
    public static void main(String[] argv) {
        Function<String, Integer> strLengthFunc = String::length;
        String name = "ashton";
        int len = strLengthFunc.apply(name);
        System.out.println("name  = " + name + ", length = " + len);

        name = "next ashton";
        len = strLengthFunc.apply(name);
        System.out.println("name  = " + name + ", length = " + len);

    }
}
