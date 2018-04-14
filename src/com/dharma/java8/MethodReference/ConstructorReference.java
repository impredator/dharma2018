package com.dharma.java8.MethodReference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class ConstructorReference {
    public static void main(String[] argv) {
        //Class constructor
        Supplier<String> func1 = () -> new String();
        System.out.println("Empty String:" + func1.get());

        Function<String, String> func2 = str -> new String(str);
        System.out.println(func2.apply("ashton"));

        Supplier<String> func3 = String::new;
        System.out.println("Empty String:" + func3.get());

        Function<String, String> func4 = String::new;
        System.out.println(func4.apply("ashton"));

        //Array constructor
        IntFunction<int[]> arrayCreator1 = size -> new int[size];
        int[] intArray1 = arrayCreator1.apply(5);
        System.out.println(Arrays.toString(intArray1));

        IntFunction<int[]> arrayCreator2 = int[]::new;
        int[] intArray2 = arrayCreator2.apply(5);
        System.out.println(Arrays.toString(intArray2));

        Function<Integer, int[]> arrayCreator3 = int[]::new;
        int[] intArray = arrayCreator3.apply(5);
        System.out.println(Arrays.toString(intArray));

        //generic reference = ClassName::<TypeName>methodName / ClassName<TypeName>::new
        Function<String[], List<String>> asList = Arrays::<String>asList;

        System.out.println(asList.apply(new String[]{"a", "b", "c"}));
    }
}
