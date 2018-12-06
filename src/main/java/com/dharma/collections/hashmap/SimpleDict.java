package com.dharma.collections.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleDict {

    public static void main(String[] args) {
        HashMap<String ,List<String>> hashMap = new HashMap<>();

        List<String> list1 = new ArrayList<>();
        list1.add("Apple");
        list1.add("Aeroplane");

        hashMap.put("A", list1);

        List<String> list2 = new ArrayList<>();
        list2.add("Bat");
        list2.add("Banana");

        hashMap.put("B", list2);

        List<String> list3 = new ArrayList<>();
        list3.add("Cat");
        list3.add("Car");

        hashMap.put("C", list3);

        for(Map.Entry<String,List<String>> hasMap : hashMap.entrySet())
        {
            System.out.println("Key " + hasMap.getKey());
             System.out.println("List item " + hasMap.getValue());
        }
    }
}
