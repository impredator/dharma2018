package com.dharma.java8.lambda;

import java.util.function.IntFunction;

public class RecursiveLambda {
    public static void main(String[] args) {
        IntFunction<Long> factorialCalc = RecursiveLambda::factorial;
        System.out.println(factorialCalc.apply(10));
    }

    private static long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
