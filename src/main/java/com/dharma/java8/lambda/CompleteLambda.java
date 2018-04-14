package com.dharma.java8.lambda;

import com.dharma.java8.Calculator;
import com.dharma.java8.DoubleCalculator;

public class CompleteLambda {
    //pass lambda expressions to methods as arguments
    private static void engine(Calculator calculator){
        int x = 2, y = 4;
        int result = calculator.calculate(x,y);
        System.out.println(result);
    }
    private static void engine(DoubleCalculator calculator){
        double x = 2.0, y = 4.0;
        double result = calculator.calculate(x,y);
        System.out.println(result);
    }

    //return as lambda
    private static Calculator create(){
        return (x,y)-> x / y;
    }

    public static void main(String[] argv) {
        //lambda behaviour
        //lambda method invocation context - method argument
        engine((Calculator) (x,y)-> x + y);
        engine((Calculator) (x,y)-> x * y);
        engine((Calculator) (x,y)-> x / y);
        engine((Calculator) (x,y)-> x % y);

        //lambda assignment context
        Calculator iCal = (x,y)-> x + y;
        System.out.println(iCal.calculate(1, 2));

        //return lambda
        System.out.println(create().calculate(2, 2));

        //cast
        engine((DoubleCalculator) ((x, y)-> x + y));
    }
}
