package com.dharma.java8.stream;

import java.util.Optional;

public class BasicOptional {
    public static void main(String[] args) {
        Optional<String> empty  = Optional.empty();
        System.out.println(empty);

        Optional<String> str = Optional.of("ashton");
        System.out.println(str);

        String nullableString = "";
        Optional<String> str2  = Optional.of(nullableString);
        System.out.println(str2);

        try {
            Optional<String> str3 = Optional.of(null);
            System.out.println(str3);
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
}
