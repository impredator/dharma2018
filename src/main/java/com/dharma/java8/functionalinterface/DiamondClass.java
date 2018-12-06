package com.dharma.java8.functionalinterface;

abstract class SuperClass {
    public abstract void doSomething();
}

class ClassA extends SuperClass{

    @Override
    public void doSomething(){
        System.out.println("doSomething implementation of A");
    }

    public void methodA(){

    }
}

class ClassB extends SuperClass{

    @Override
    public void doSomething(){
        System.out.println("doSomething implementation of B");
    }

    public void methodB(){

    }
}

//Diamond Problem
//class ClassC extends ClassA, ClassB{
//
//    public void doSomething(){
//        //calling super class method
//        doSomething();
//    }
//
//}

//Inheritance Problem
//class ClassC{
//    public void methodC(){
//    }
//    public void doSomething(){
//    }
//}
//class ClassD extends ClassC{
//
//    public int doSomething(){
//        return 0;
//    }
//}


//Diamond resolution: composition
//favor composition over inheritance
class Composition {
    ClassA objA = new ClassA();
    ClassB objB = new ClassB();

    public void doSomething(){
        objA.doSomething();
        objB.doSomething();
    }

    public void methodA(){
        objA.methodA();
    }

    public void methodB(){
        objB.methodB();
    }
}

class RefinedComposition {

    SuperClass obj = null;

    public RefinedComposition(SuperClass o){
        this.obj = o;
    }
    public void doSomething(){
        obj.doSomething();
    }
}

//Diamond resolution: inner class
class InnerClass {
    class InnerA extends ClassA {

    }

    class InnerB extends ClassB {

    }

    public void doSomethingA() {
        new InnerA().doSomething();
    }

    public void doSomethingB() {
        new InnerB().doSomething();
    }
}

public class DiamondClass {
    public static void main(String[] args) {
        // 1
        Composition composition = new Composition();
        composition.doSomething();

        // 2
        RefinedComposition obj1 = new RefinedComposition(new ClassA());
        RefinedComposition obj2 = new RefinedComposition(new ClassB());
        obj1.doSomething();
        obj2.doSomething();

        // 3
        InnerClass inner = new InnerClass();
        inner.doSomethingA();
        inner.doSomethingB();
    }
}
