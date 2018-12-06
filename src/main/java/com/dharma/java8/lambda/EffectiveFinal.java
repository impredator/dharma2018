package com.dharma.java8.lambda;

interface Coffee {
    void service(String shop, String name);
}

public class EffectiveFinal {
    public static void main(String args[]) {
        int size = 10;
//        size = 5;
//        Coffee order = (shop, String name) ->
//        Coffee order = (final String shop, final String name) ->
//        Coffee order = (shop, final name) ->
        Coffee order = (shop, name) ->
                System.out.println(shop + " order: " + name + " size: " + size);

        order.service("Starbucks","latte");
    }
}
