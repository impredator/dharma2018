package com.dharma.patterns.gof.create.singleton;

class BillPughSingleton {

    private BillPughSingleton() {
    }

    //inner class 不会被载入内存，只有调用getInstance时候才会被加载
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

public class DemoBillPughSingleton {
    public static void main(String[] args) {
        BillPughSingleton single = BillPughSingleton.getInstance();
        System.out.println(single);
    }
}

