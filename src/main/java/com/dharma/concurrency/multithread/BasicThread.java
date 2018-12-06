package com.dharma.concurrency.multithread;

public class BasicThread extends Thread {

    public BasicThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("THREAD START " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            Processing();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("THREAD END " + Thread.currentThread().getName());
    }

    private void Processing() throws InterruptedException {
        System.out.println("PROCESSING...");
        Thread.sleep(5000);
    }

}
