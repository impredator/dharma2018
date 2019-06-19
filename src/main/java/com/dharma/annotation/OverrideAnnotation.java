package com.dharma.annotation;

class BaseClass {
    public void doSomething(String str){
        System.out.println("Base impl:"+str);
    }

}

class ChildClass extends BaseClass{
//    @Override
//    public void doSomething(String str){
//        System.out.println("Child impl:"+str);
//    }

    public void doSomething(Object str){
        System.out.println("Base impl:"+str);
    }

}

public class OverrideAnnotation {
    public static void main(String[] args) {
        BaseClass bc = new ChildClass();
        bc.doSomething("override");
    }
}
