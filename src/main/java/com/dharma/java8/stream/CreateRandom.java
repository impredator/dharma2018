package com.dharma.java8.stream;

import java.util.Random;
import java.util.stream.Stream;

public class CreateRandom {
    public static void main(String[] args) {
        Stream.generate(new Random()::nextInt)
//        new Random().ints()
                .limit(5)
                .forEach(System.out::println);
    }
}
