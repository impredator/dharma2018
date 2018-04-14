package com.dharma.generics;

public class NonGenericClass {

    private Object item;

    public Object get() {
        return item;
    }

    public void set(Object item) {
        this.item = item;
    }

    public static void main(String args[]){
        NonGenericClass type = new NonGenericClass();
        type.set("people");
//        type.set(10);

        //type casting, error prone and can cause ClassCastException
        String out = (String) type.get();
        System.out.println(out);
    }
}
