package com.dharma.java8.stream;

import java.util.stream.Stream;

public class CreateEmpty {
    public static void main(String[] args) {
        Stream<String> stream = Stream.empty();
        stream.forEach(System.out::println);
    }
}
