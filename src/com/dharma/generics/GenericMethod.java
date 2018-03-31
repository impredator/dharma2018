package com.dharma.generics;

public class GenericMethod {

    public static <T> boolean isEqual(GenericClass<T> g1, GenericClass<T> g2){
        return g1.get().equals(g2.get());
    }

    public static <T extends Comparable<T>> int compare(T t1, T t2){
        return t1.compareTo(t2);
    }

    public static void main(String args[]){
        GenericClass<String> g1 = new GenericClass<>();
        g1.set("xi'an");

        GenericClass<String> g2 = new GenericClass<>();
        g2.set("xi'an");

        boolean isEqual = GenericMethod.<String>isEqual(g1, g2);
//        isEqual = GenericMethod.isEqual(g1, g2);  //type inference
        System.out.println(isEqual);

        int compareResult = GenericMethod.<Integer>compare(9, 8);
        System.out.println(compareResult);
    }
}
