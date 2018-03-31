package com.dharma.collections.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIterator {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) list.add(i);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            int i = (int) iterator.next();
            System.out.print(i + ", ");
        }
        System.out.println("\n" + list);

        iterator = list.iterator();
        while (iterator.hasNext()) {
            int x = (int) iterator.next();
            if (x % 2 == 0) iterator.remove();
        }
        System.out.println(list);

        iterator = list.iterator();
        while (iterator.hasNext()) {
            int x = (int) iterator.next(); //ConcurrentModificationException here
            System.out.print(x + ", ");
//            if (x == 1) list.add(10);
        }
    }
}
