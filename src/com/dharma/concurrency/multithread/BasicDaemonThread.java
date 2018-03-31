package com.dharma.concurrency.multithread;

public class BasicDaemonThread {

    public static void main(String[] args) throws InterruptedException {
        Thread dt = new Thread(new DaemonThread(), "dt");
        dt.setDaemon(true);
        dt.start();

        Thread.sleep(30000);
        System.out.println("Finishing program");
    }

}

class DaemonThread implements Runnable {

    @Override
    public void run() {
        while (true) {
            processSomething();
        }
    }

    private void processSomething() {
        try {
            System.out.println("Processing daemon thread");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
