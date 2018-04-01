package com.dharma.concurrency.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BasicTask implements Runnable {
    private int taskId;
    private int loopCounter;

    BasicTask(int taskId, int loopCounter) {
        this.taskId = taskId;
        this.loopCounter = loopCounter;
    }

    public void run() {
        for (int i = 1; i <= loopCounter; i++) {
            try {
                System.out.println("Task #" + this.taskId + "  - Iteration #" + i);
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Task #" + this.taskId
                        + "  has  been  interrupted.");
                break;
            }
        }
    }
}

public class BasicExecutorService {
    public static void main(String[] args) {
        final int THREAD_COUNT = 3;
        final int LOOP_COUNT = 3;
        final int TASK_COUNT = 5;

        ExecutorService exec = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 1; i <= TASK_COUNT; i++) {
            BasicTask task = new BasicTask(i, LOOP_COUNT);
            exec.submit(task);
        }
        exec.shutdown();
    }
}