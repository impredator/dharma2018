package com.dharma.collections.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ArrayListForEach {

    public static void main(String[] args) {

        List<String> stocks = new ArrayList<>();
        stocks.add("Google");
        stocks.add("Apple");
        stocks.add("Microsoft");
        stocks.add("Facebook");

        Consumer<Object> consumer = new ArrayListForEach().new MyConsumer();

        stocks.forEach(consumer);

        stocks.forEach(x -> System.out.println("Processed " + x));

    }

    class MyConsumer implements Consumer<Object> {

        @Override
        public void accept(Object t) {
            System.out.println("Processing " + t);
        }

    }
}
