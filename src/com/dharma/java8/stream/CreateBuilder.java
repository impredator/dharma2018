package com.dharma.java8.stream;

import java.util.stream.Stream;

public class CreateBuilder {
    public static void main(String[] args) {
        Stream<String> stream = Stream.<String>builder()
                .add("Web")
                .add("Java")
                .add("Spring")
                .add("Docker")
                .build();
        stream.forEach(System.out::println);
    }
}
