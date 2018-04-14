package com.dharma.generics;

class Triple<T extends Number & Comparable<T>> {
    T value1;
    T value2;
    T value3;

    public Triple(T v1, T v2, T v3) {
        value1 = v1;
        value2 = v2;
        value3 = v3;
    }

    public T readValue1() {
        return value1;
    }

    public void setValue1(T val) {
        value1 = val;
    }

    public T addValues() {
        Number res1 = value1.doubleValue() + value2.doubleValue() + value3.doubleValue();
        return (T) res1;
    }

    public T largest() {
        T res = value1;
        if (value2.compareTo(res) > 0)
            res = value2;
        if (value3.compareTo(res) > 0)
            res = value3;
        return res;
    }

    public static void main(String[] args) {

        Triple<Integer> t = new Triple<>(8, 10, 7);
        System.out.println("Original Value1=" + t.readValue1());
        System.out.println("Adding 3 Values=" + t.addValues());
        System.out.println("Largest= " + t.largest());
        t.setValue1(13);
        System.out.println("Largest= " + t.largest());
    }

}