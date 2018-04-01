package com.dharma.concurrency.concurrent.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableTask implements Callable<Integer> {
    private int taskId;

    CallableTask(int taskId) {
        this.taskId = taskId;
    }

    public Integer call() throws InterruptedException {
        int total = taskId;
        try {
            System.out.println("Task #" + this.taskId);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Task #" + this.taskId
                    + "  has  been  interupted.");
            throw e;
        }
        total += taskId;
        return total;
    }
}

public class CallableExecutorService {

    public static void main(String[] args) throws Exception {

        ExecutorService exec = Executors.newFixedThreadPool(3);

        CallableTask task = new CallableTask(1);
        Future<Integer> submittedTask = exec.submit(task);

        Integer result = submittedTask.get();
        System.out.println("Task's total  sleep time: " + result + "  seconds");
        exec.shutdown();
    }
}
