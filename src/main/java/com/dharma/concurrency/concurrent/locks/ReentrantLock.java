package com.dharma.concurrency.concurrent.locks;

public class ReentrantLock implements Runnable {
    public static java.util.concurrent.locks.ReentrantLock lock = new java.util.concurrent.locks.ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for(int j = 0; j < 10000000; j++) {
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock rl = new ReentrantLock();
        Thread t1 = new Thread(rl);
        Thread t2 = new Thread(rl);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(i);

    }
}
