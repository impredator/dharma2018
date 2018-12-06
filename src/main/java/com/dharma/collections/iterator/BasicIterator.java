package com.dharma.collections.iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BasicIterator {
    public static void main(String[] args)
    {
        List<String> names = new LinkedList<>();
        names.add("ashton");
        names.add("alex");
        names.add("ashley");

        Iterator<String> namesIterator = names.iterator();

        //external iterator
        while(namesIterator.hasNext()){
            System.out.println(namesIterator.next());
        }

        //internal iterator
        for(String name: names){
            System.out.println(name);
        }

    }
}
