package com.dharma.concurrency.multithread;

public class Runner {
    public static void main(String[] args) {
        Thread t1 = new Thread(new BasicRunnable(), "t1");
        Thread t2 = new Thread(new BasicRunnable(), "t2");
        System.out.println("Starting Runnable threads");
        t1.start();
        t2.start();
        System.out.println("Runnable Threads has been started");

        Thread t3 = new BasicThread("t3");
        Thread t4 = new BasicThread("t4");
        System.out.println("Starting Threads");
        t3.start();
        t4.start();
        System.out.println("Threads has been started");
    }
}
