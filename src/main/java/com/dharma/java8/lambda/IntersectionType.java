package com.dharma.java8.lambda;

import com.dharma.java8.Calculator;

public class IntersectionType {
    public static void main(String[] argv) {
        java.io.Serializable ser = (java.io.Serializable & Calculator) (x, y) -> x + y;

        System.out.println(ser instanceof java.io.Serializable);
        System.out.println(ser instanceof Calculator);

        System.out.println(((Calculator) ser).calculate(5, 1));
    }
}
