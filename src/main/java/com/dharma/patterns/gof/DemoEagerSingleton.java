package com.dharma.patterns.gof;

class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton();

    //private constructor to avoid client applications to use constructor
    private EagerSingleton(){}

    public static EagerSingleton getInstance(){
        return instance;
    }

    public String getPaw() {
        return paw;
    }

    private String paw = "I yao eat ren";
}

public class DemoEagerSingleton {
    public static void main(String[] args) {
        EagerSingleton single = EagerSingleton.getInstance();
        System.out.println(single.getPaw());
    }
}
