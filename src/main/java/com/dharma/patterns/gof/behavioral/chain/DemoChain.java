package com.dharma.patterns.gof.behavioral.chain;

import java.util.Random;

class Processor {
    private final static Random RANDOM = new Random();
    private static int nextID = 1;
    private int id = nextID++;
    private Processor nextInChain;

    //逐级向下添加next
    public void add(Processor next) {
        if (nextInChain == null) {
            nextInChain = next;
        } else {
            nextInChain.add(next);
        }
    }

    //收尾，最后一个指向第一个（相当于取模）
    public void wrapAround(Processor root) {
        if (nextInChain == null) {
            nextInChain = root;
        } else {
            nextInChain.wrapAround(root);
        }
    }

    public void execute(int num) {
        if (RANDOM.nextInt(4) != 0) {
            System.out.println("   " + id + "-busy  ");
            nextInChain.execute(num);
        } else {
            System.out.println(id + "-handled-" + num);
        }
    }
}

public class DemoChain {
    public static void main(String[] args) {
        Processor rootChain = new Processor();
        rootChain.add(new Processor());
        rootChain.add(new Processor());
        rootChain.add(new Processor());
        rootChain.wrapAround(rootChain);
        for (int i = 1; i < 6; i++) {
            System.out.println("Operation #" + i + ":");
            rootChain.execute(i);
            System.out.println();
        }
    }
}
