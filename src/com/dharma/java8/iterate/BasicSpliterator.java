package com.dharma.java8.iterate;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class BasicSpliterator {
    public static void main(String[] args)
    {
        List<String> names = new ArrayList<>();
        names.add("Rams");
        names.add("Posa");
        names.add("Chinni");

        Spliterator<String> namesSpliterator = names.spliterator();

        namesSpliterator.forEachRemaining(System.out::println);
    }
}
