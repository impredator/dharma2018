package com.dharma.java8.stream;

import java.util.stream.Stream;

public class CreateIterate {
    public static void main(String[] args) {
        Stream.iterate(2, n -> n + 1)
                .peek(n -> System.out.println("origin: " + n))
                .filter(CreateIterate::isOdd)
                .peek(n -> System.out.println("filtered: " + n))
                .skip(10)
                .peek(n -> System.out.println("skipped: " + n))
                .limit(5)
                .forEach(System.out::println);
    }

    private static boolean isOdd(long number) {
        return number % 2 != 0;
    }
}
