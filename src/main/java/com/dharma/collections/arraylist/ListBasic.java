package com.dharma.collections.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ListBasic {
    public static void main(String args[]) {
        List<String> vowels = new ArrayList<>();

        vowels.add("A");
        vowels.add("I");

        vowels.add(1, "E");
//        System.out.println(vowels);

        List<String> list = new ArrayList<>();
        list.add("O");
        list.add("U");

        vowels.addAll(list);
        list.add("X");
        System.out.println(vowels);

        list.clear();

//        System.out.println("letters list size = " + vowels.size());

        vowels.set(2, "E");
//        System.out.println(vowels);

        vowels.clear();
        vowels.add("E");
        vowels.add("E");
        vowels.add("I");
        vowels.add("O");
        list = vowels.subList(0, 2);
        System.out.println("letters = " + vowels + ", list = " + list);
        vowels.set(0, "A");
        System.out.println("letters = " + vowels + ", list = " + list);
        list.add("U");
        System.out.println("letters = " + vowels + ", list = " + list);
    }
}
