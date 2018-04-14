package com.dharma.java8.functionalinterface;

interface IFormula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(positive(a));
    }

    static int positive(int a) {
        return a > 0 ? a : 0;
    }

    default void log(Number result) {
        System.out.println(result);
    }
}

class Formula implements IFormula {

    @Override
    public double calculate(int a) {
        double result = sqrt((int)sqrt(a));
        log(result);
        return result;
    }
}

public class DefaultMethod {

    public static void main(String[] args) {
        IFormula formula1 = new IFormula() {
            @Override
            public double calculate(int a) {
                double result = sqrt(a * 100);
                log(result);
                return result;
            }
        };

        formula1.calculate(100);
        formula1.log(formula1.sqrt(-23));
        formula1.log(IFormula.positive(-4));

        IFormula formula2 = new Formula();
        formula2.calculate(16);

        IFormula formula3 = (a) -> Math.sqrt(a * 100);
        System.out.println(formula3.calculate(-4));

    }

}
