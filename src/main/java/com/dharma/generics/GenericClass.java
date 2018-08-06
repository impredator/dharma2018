package com.dharma.generics;

public class GenericClass<T> {

    private T item;

    public T get(){
        return this.item;
    }

    public void set(T item){
        this.item=item;
    }

    public static void main(String args[]){
        GenericClass<String> type = new GenericClass();
        type.set("pancake"); //valid
        System.out.println(type.get());

        GenericClass type1 = new GenericClass(); //raw type
        type1.set("apple"); //valid
        type1.set(10); //valid and autoboxing support
        System.out.println(type1.get());
    }
}
