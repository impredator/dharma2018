package com.dharma.java8.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class CreateCollection {
    public static void main(String[] args) {
        Stream<String> classes = Arrays.stream(new String[] {"Java", "Dharma", "2018"});
        classes.forEach(System.out::println);

        Set<String> names = new HashSet<>();
        names.add("Java");
        names.add("Dharma");
        names.add("2018");
        System.out.println(names);

        Stream<String> sequentialStream  = names.stream();
        sequentialStream.forEach(System.out::println);

        Stream<String> parallelStream = names.parallelStream();
        parallelStream.forEach(System.out::println);
    }
}
