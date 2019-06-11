package com.dharma.concurrency.concurrent.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.RejectedExecutionHandler;

class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r.toString() + " is rejected");
    }

}

class MyMonitorThread implements Runnable {
    private ThreadPoolExecutor executor;
    private int seconds;
    private boolean run = true;

    MyMonitorThread(ThreadPoolExecutor executor, int delay) {
        this.executor = executor;
        this.seconds = delay;
    }

    public void shutdown() {
        this.run = false;
    }

    @Override
    public void run() {
        while (run) {
            System.out.println(
                    String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                            this.executor.getPoolSize(),
                            this.executor.getCorePoolSize(),
                            this.executor.getActiveCount(),
                            this.executor.getCompletedTaskCount(),
                            this.executor.getTaskCount(),
                            this.executor.isShutdown(),
                            this.executor.isTerminated()));
            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class WorkerThread implements Runnable {

    private String command;

    WorkerThread(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End.");
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}

public class BasicThreadPollExecutor {

    public static void main(String args[]) throws InterruptedException {
        RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        // max thread is 4 + 2 = 6, 4 of 10 will be rejected
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), threadFactory, rejectionHandler);
        MyMonitorThread monitor = new MyMonitorThread(executorPool, 3);
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();
        for (int i = 0; i < 10; i++) {
            executorPool.execute(new WorkerThread("cmd" + i));
        }

        Thread.sleep(30000);
        executorPool.shutdown();
        Thread.sleep(5000);
        monitor.shutdown();

    }
}