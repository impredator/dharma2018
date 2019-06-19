package com.dharma.java8.iterate;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class BasicSpliterator {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Rams");
        names.add("Posa");
        names.add("Chinni");
        names.add("Pogo");
        names.add("Nova");
        names.add("831");
        names.add("007");

        Spliterator<String> namesSpliterator = names.spliterator();
        Spliterator<String> nextNamesSpliterator = namesSpliterator.trySplit();

        System.out.println("forEachRemaining...");
        namesSpliterator.forEachRemaining(System.out::println);

        System.out.println("tryAdvance...");
        nextNamesSpliterator.tryAdvance(System.out::println);
        System.out.println("tryAdvance...");
        nextNamesSpliterator.tryAdvance(System.out::println);
        System.out.println("tryAdvance...");
        nextNamesSpliterator.tryAdvance(System.out::println);
//        nextNamesSpliterator.forEachRemaining(System.out::println);

    }
}
