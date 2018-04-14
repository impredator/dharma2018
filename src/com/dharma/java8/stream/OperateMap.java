package com.dharma.java8.stream;

import java.util.stream.IntStream;

public class OperateMap {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 5)
                .map(n -> n * n)
                .forEach(System.out::println);

    }
}
