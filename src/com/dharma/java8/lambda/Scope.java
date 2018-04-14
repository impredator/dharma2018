package com.dharma.java8.lambda;

import java.util.function.Function;

public class Scope {
    public Scope() {
        Function<String, String> func1 = x -> {
            System.out.println(this);
            return x;
        };
        System.out.println(func1.apply("Cool"));
    }

    public String toString() {
        return "I am Scope";
    }

    public static void main(String[] argv) {
        new Scope();
    }
}
