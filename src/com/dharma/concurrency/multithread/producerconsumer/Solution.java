package com.dharma.concurrency.multithread.producerconsumer;

public class Solution {
    public static void main(String[] args) {
        Message msg = new Message("process it");

        Waiter ashton = new Waiter(msg);
        new Thread(ashton, "ashton").start();

        Waiter ashley = new Waiter(msg);
        new Thread(ashley, "ashley").start();

        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start();

        System.out.println("All the threads are started");
    }
}
