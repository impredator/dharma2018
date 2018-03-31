package com.dharma.concurrency.multithread.threadsafety;

public class ThreadSafety1 {

    public static void main(String[] args) throws InterruptedException {

        SyncComputingThread pt = new SyncComputingThread();

        Thread t1 = new Thread(pt, "t1");
        t1.start();

        Thread t2 = new Thread(pt, "t2");
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Processing count=" + pt.getCount());
    }

}

class SyncComputingThread implements Runnable {
    private int count;
    private final Object mutex = new Object();

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            processSomething(i);
            synchronized (mutex) {
                count++;
                System.out.println(Thread.currentThread().getName() + " Processing... " + i + " After Count: " + this.count);
            }
        }
    }

    public int getCount() {
        return this.count;
    }

    private void processSomething(int i) {
        try {
            System.out.println(Thread.currentThread().getName() + " Processing... " + i + " Before Count: " + this.count);
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
