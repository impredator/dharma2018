package com.dharma.java8.optional;

import java.util.Optional;

public class MoreOptional {
    public static void main(String[] args) {

        Optional<String> nonEmptyGender = Optional.of("male");
        Optional<String> emptyGender = Optional.empty();

        System.out.println("Non-Empty Optional:: " + nonEmptyGender.map(String::toUpperCase));
        System.out.println("Empty Optional    :: " + emptyGender.map(String::toUpperCase));

        Optional<Optional<String>> nonEmptyOtionalGender = Optional.of(Optional.of("male"));
        System.out.println("Optional value   :: " + nonEmptyOtionalGender);
        System.out.println("Optional.map     :: " + nonEmptyOtionalGender.map(gender -> gender.map(String::toUpperCase)));
        System.out.println("Optional.flatMap :: " + nonEmptyOtionalGender.flatMap(gender -> gender.map(String::toUpperCase)));

        //Filter on Optional
        System.out.println(nonEmptyGender.filter(g -> g.equals("male")));
        System.out.println(nonEmptyGender.filter(g -> g.equalsIgnoreCase("MALE")));
        System.out.println(emptyGender.filter(g -> g.equalsIgnoreCase("MALE")));


        if (nonEmptyGender.isPresent()) {
            System.out.println("Value available.");
        } else {
            System.out.println("Value not available.");
        }

        nonEmptyGender.ifPresent(g -> System.out.println("In gender Option, value available."));
        //condition failed, no output print
        emptyGender.ifPresent(g -> System.out.println("In emptyGender Option, value available."));

        System.out.println(nonEmptyGender.orElse("<N/A>"));
        System.out.println(emptyGender.orElse("<N/A>"));

        System.out.println(nonEmptyGender.orElseGet(() -> "<N/A>"));
        System.out.println(emptyGender.orElseGet(() -> "<N/A>"));




    }
}
