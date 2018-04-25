package com.dharma.patterns.gof.create.singleton;

class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    private StaticBlockSingleton() {
    }

    //static block initialization for exception handling
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        String ref = super.toString().split("@")[1];
        return "I am " + ref + ", a static block singleton!";
    }
}

public class DemoStaticBlockSingleton {
    public static void main(String[] args) {
        StaticBlockSingleton single = StaticBlockSingleton.getInstance();
        System.out.println(single);
    }
}
