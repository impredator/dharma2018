package com.dharma.collections.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapCompute {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put(null, "10");
        map.put("10", null);

        System.out.println("map before compute = "+map);
        for (String key : map.keySet()) {
            map.compute(key, (k,v) -> k+v);
        }
        for (Map.Entry entry : map.entrySet()) {
            map.put((String)entry.getKey(), (String)entry.getKey()+(String)entry.getValue());
        }
        map.compute("5", (k,v) -> k+v); //key not present, v = null
        System.out.println("map after compute = "+map);
    }

}
