package com.dharma.generics;

import java.util.List;

class B1 {

}

class B2 extends B1 {

}

class B3 extends B2 {

}


class TestTypeErasure {

    public <T> void display(T data, List<? extends B1> list) {
        System.out.println(list);
    }
}

/*
 *in the above example, the compiler will use type eraser and treat the class like this.
 * basically, whichever class is used for upper bound, with that class actual type parameter will get replaced.
 * see the below example.
 *
 */
class TestTypeErasureAfterCompiler {

    public <B1> void display(B1 data, B1 list) {
        System.out.println(list);
    }
}

/*=========================================================End of Type Erasure=====================================================*/

class Node<T> {

    public T data;

    public Node(T data) {
        this.data = data;
    }

    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }
}

class MyNode extends Node<Integer> {

    public MyNode(Integer data) {
        super(data);

    }

    public void setData(Integer data) {
        System.out.println("Node.setData");
        super.setData(data);
    }
}

public class TypeErasure {

    public static void main(String[] args) {

        MyNode mn = new MyNode(3);
        Node n = mn;
        n.setData("Hello");
        Integer x = mn.data; //class cast exception will be thrown.
    }

}