package com.dharma.collections.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiConsumer;

public class HashMapForEach {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", null);
        map.put(null, "100");

        //1
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        //2
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }


        //3
        BiConsumer<String, String> action = new MyBiConsumer();
        map.forEach(action);

        map.forEach((k,v) -> {System.out.println("Key = "+k+", Value = "+v);});
    }

}

class MyBiConsumer implements BiConsumer<String, String> {

    @Override
    public void accept(String t, String u) {
        System.out.println("Key = " + t);
        System.out.println("Processing on value = " + u);
    }

}
