package com.dharma.java8.iterate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class BasicForEach {

    public static void main(String[] args) {

        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            myList.add(i);
        }

        Iterator<Integer> it = myList.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            System.out.println("Iterator Value::" + i);
//            if (i.equals(3)) myList.remove(i);
        }

        myList.forEach(t -> System.out.println("forEach anonymous class Value::" + t));

        MyConsumer action = new MyConsumer();
        myList.forEach(action);

    }

}

class MyConsumer implements Consumer<Integer> {

    public void accept(Integer t) {
        System.out.println("Consumer impl Value::" + t);
    }

}
