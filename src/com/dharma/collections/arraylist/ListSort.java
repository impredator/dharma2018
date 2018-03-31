package com.dharma.collections.arraylist;

import java.util.*;

class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ListSort {

    public static void main(String[] args) {

        List<Person> ints = new ArrayList<>();
        ints.add(new Person("chris", 30));
        ints.add(new Person("myers", 13));
        ints.add(new Person("jordan", 28));
        ints.add(new Person("runner", 31));
        ints.add(new Person("ashton", 60));
        ints.add(new Person("alex", 80));
        ints.add(new Person("manisa", 10));

//        Collections.sort(ints);
//        System.out.println("Natural Sorting: " + ints);

//        ints.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        System.out.println("Reverse Sorting: " + ints);

        ints.sort((o1, o2) -> o1.age - o2.age);
        ints.forEach(x -> System.out.println("Name: " + x.name + " Age: " + x.age));
        System.out.println("Reverse Sorting: " + ints);
    }
}
