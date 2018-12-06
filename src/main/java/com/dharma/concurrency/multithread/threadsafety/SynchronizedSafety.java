package com.dharma.concurrency.multithread.threadsafety;

public class SynchronizedSafety {

    public static void main(String[] args) throws InterruptedException {

        ComputingThread pt = new ComputingThread();

        Thread t1 = new Thread(pt, "t1");
        t1.start();

        Thread t2 = new Thread(pt, "t2");
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Processing count=" + pt.getCount());
    }

}

class ComputingThread implements Runnable {
    private int count;

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            processSomething(i);
            count++;
            System.out.println("Processing... " + i + " After Count: " + this.count);
        }
    }

    public int getCount() {
        return this.count;
    }

    private void processSomething(int i) {
        try {
            System.out.println("Processing... " + i + " Before Count: " + this.count);
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
