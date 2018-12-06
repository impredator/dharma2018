package com.dharma.java8.functionalinterface;

interface InterfaceA {
    void doSomething();
}

interface InterfaceB {
    void doSomething();
}

interface InterfaceC extends InterfaceA, InterfaceB {
    //same method is declared in InterfaceA and InterfaceB both
    void doSomething();

}

public class DiamondInterface implements InterfaceA, InterfaceB, InterfaceC {
    @Override
    public void doSomething() {
        System.out.println("doSomething implementation of concrete class");
    }

    public static void main(String[] args) {
        InterfaceA objA = new DiamondInterface();
        InterfaceB objB = new DiamondInterface();
        InterfaceC objC = new DiamondInterface();

        //all the method calls below are going to same concrete implementation
        objA.doSomething();
        objB.doSomething();
        objC.doSomething();
    }

}
