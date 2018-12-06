package com.dharma.java8.stream;

import java.util.stream.Stream;

public class CreateGenerate {
    public static void main(String[] args) {
        Stream.generate(CreateGenerate::next)
                .limit(100)
                .forEach(System.out::println);

    }

    static int i = 0;

    private static int next() {
        i++;
        return i;
    }
}
