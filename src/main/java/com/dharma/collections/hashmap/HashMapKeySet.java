package com.dharma.collections.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapKeySet {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");

        Set<String> keySet = map.keySet();
        System.out.println(keySet);

        map.put("4", "d");  // keySet is modified if map changes
        System.out.println(keySet);

        keySet.remove("1");
        System.out.println(map); // map is also modified if keySet changes

        keySet = new HashSet<>(map.keySet()); // copies the key to new Set
        map.put("5", "5");
        System.out.println(map);
        System.out.println(keySet);
    }

}
