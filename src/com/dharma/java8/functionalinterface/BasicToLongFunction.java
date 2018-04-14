package com.dharma.java8.functionalinterface;

import java.util.function.Predicate;
import java.util.function.ToLongFunction;

public class BasicToLongFunction {

    public static void main(String[] args) {
        ToLongFunction<String> lf  = (x)-> Long.parseLong(x);
        System.out.println(lf.applyAsLong("2"));

        Predicate<String> pi  = (s)-> s.length() > 5;
        System.out.println(pi.test("ashton "));
    }
}