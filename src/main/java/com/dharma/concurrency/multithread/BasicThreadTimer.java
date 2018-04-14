package com.dharma.concurrency.multithread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class BasicThreadTimer extends TimerTask {

    @Override
    public void run() {
        System.out.println("Timer task started at:" + new Date());
        completeTask();
        System.out.println("Timer task finished at:" + new Date());
    }

    private void completeTask() {
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        TimerTask timerTask = new BasicThreadTimer();
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 7 * 1000);
        System.out.println("TimerTask started");

        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        System.out.println("TimerTask cancelled");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
