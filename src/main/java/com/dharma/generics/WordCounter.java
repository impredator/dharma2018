package com.dharma.generics;

import java.util.HashMap;

public class WordCounter {

    public static void main(String[] args) {
        Integer demo[]={10,25,32,65,56,65,10,25,35};
        HashMap<?, Integer> map1=wordCount(demo);
        System.out.println(map1);

        String str = "Hi Helo Hello Hi hi";
        String[] words = str.split(" ");
        HashMap<?, Integer> map2=wordCount(words);
        System.out.println(map2);
    }

    private static <T>HashMap<T,Integer> wordCount(T group[]) {
        HashMap<T,Integer> map = new HashMap<T, Integer>();
        for (T member : group) {
            if (map.get(member) == null) {
                map.put(member, 1);
            } else {
                int value=(int) map.get(member) + 1;
                map.put( member, value);
            }
        }
        return map;
    }
}
