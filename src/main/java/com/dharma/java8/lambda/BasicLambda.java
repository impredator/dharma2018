package com.dharma.java8.lambda;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class BasicLambda {
    private static boolean isPrime(int number) {
//        if(number < 2) return false;
//        for(int i=2; i<number; i++){
//            if(number % i == 0) return false;
//        }
//        return true;

        IntPredicate isDivisible = index -> number % index != 0;

        return number > 1
                && IntStream.range(2, number).allMatch(isDivisible);
    }

    public static int sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.parallelStream()
                .filter(predicate)
                .mapToInt(i -> i)
                .sum();
    }

    public static int findSquareOfMaxOdd(List<Integer> numbers) {
        return numbers.stream()
                .filter(BasicLambda::isOdd)   //java 8 method reference
                .filter(i -> isGreaterThan3(i))
                .filter((i) -> i < 11)
                .max(Comparator.naturalOrder())
                .map(i -> i * i)
                .get();
    }

    private static boolean isOdd(int i) {
        return i % 2 != 0;
    }

    private static boolean isGreaterThan3(int i) {
        return i > 3;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(10, 9, 4, 7, 6, 5, 1, 3, 2, 8));

        System.out.println(sumWithCondition(numbers, n -> true));
        System.out.println(sumWithCondition(numbers, i -> i%2==0));
        System.out.println(sumWithCondition(numbers, i -> i>5));

        System.out.println(findSquareOfMaxOdd(numbers));

        System.out.println(isPrime(11));
    }
}
