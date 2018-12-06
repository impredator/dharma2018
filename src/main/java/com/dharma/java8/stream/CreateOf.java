package com.dharma.java8.stream;

import java.util.stream.Stream;

public class CreateOf {
    public static void main(String[] args) {
        Stream<String> stream  = Stream.of("i'm ashotn");
        stream.forEach(System.out::println);

        Stream<String> stream1  = Stream.of("Web", "Java",  "Spring", "Docker");
        stream1.forEach(System.out::println);

        String[] names = {"Web", "Java",  "Spring", "Docker"};
        Stream<String> stream2 = Stream.of(names);
        stream2.forEach(System.out::println);
    }
}
