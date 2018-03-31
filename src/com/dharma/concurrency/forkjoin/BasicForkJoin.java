package com.dharma.concurrency.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class Order extends RecursiveTask<String> {
    private int order;

    public Order(int order) {
        this.order = order;
    }

    @Override
    protected String compute() {
        String result = "";

        if (this.order < 5) {
            return this.getOrder(order);
        }

        List<RecursiveTask<String>> forks = new ArrayList<>();

        for (int i = 1; i < this.order; i++) {
            Order subTask = new Order(i);
            subTask.fork();
            forks.add(subTask);
        }

        for (RecursiveTask<String> subTask : forks) {
            result = result + subTask.join();
        }
        return result;
    }

    public String getOrder(int order) {
        return " [" + order + "] ";
    }
}

public class BasicForkJoin {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        Order task = new Order(5);
        String result = pool.invoke(task);
        System.out.println("Order is " + result);
    }
}
