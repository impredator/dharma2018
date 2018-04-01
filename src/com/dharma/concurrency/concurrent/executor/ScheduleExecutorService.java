package com.dharma.concurrency.concurrent.executor;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class ScheduledTask implements Runnable {
    private int taskId;

    ScheduledTask(int taskId) {
        this.taskId = taskId;
    }

    public void run() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Task #" + this.taskId + "  ran  at "
                + currentDateTime);
    }
}

public class ScheduleExecutorService {
    public static void main(String[] args) {
        ScheduledExecutorService sexec = Executors.newScheduledThreadPool(3);

        ScheduledTask task1 = new ScheduledTask(1);
        ScheduledTask task2 = new ScheduledTask(2);

        // Task #1 will run after 2 seconds
        sexec.schedule(task1, 2, TimeUnit.SECONDS);

        // Task #2 runs after 5 seconds delay and keep running every 10 seconds
        sexec.scheduleAtFixedRate(task2, 0, 10, TimeUnit.SECONDS);

        try {
            TimeUnit.SECONDS.sleep(25);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sexec.shutdown();
    }
}