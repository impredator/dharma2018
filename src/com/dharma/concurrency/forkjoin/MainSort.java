package com.dharma.concurrency.forkjoin;

import com.dharma.Utils;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class QuickSort {

    private static int partition(Long[] numbers, int low, int high) {

        Long soldier = numbers[low];
        while (low < high) {
            while (low < high) {
                if (numbers[high] < soldier) {
                    numbers[low] = numbers[high];
                    break;
                }
                high--;
            }
            while (low < high) {
                if (numbers[low] > soldier) {
                    numbers[high] = numbers[low];
                    break;
                }
                low++;
            }
        }
        numbers[low] = soldier;
        return low;
    }

    public static void qsort(Long[] numbers, int low, int high) {
        if (low < high) {
            int soldier = partition(numbers, low, high);
            qsort(numbers, low, soldier - 1);
            qsort(numbers, soldier + 1, high);
        }
    }

}

class ParallelQuickSort extends RecursiveAction {

    private int threshold = 30;
    private int low;
    private int high;
    private Long[] numbers;

    ParallelQuickSort(Long[] numbers, int threshold) {
        this.numbers = numbers;
        this.low = 0;
        this.high = numbers.length - 1;
        this.threshold = threshold;
    }

    private ParallelQuickSort(Long[] numbers, int low, int high) {
        this.low = low;
        this.high = high;
        this.numbers = numbers;
    }

    private static int partition(Long[] numbers, int low, int high) {

        Long soldier = numbers[low];
        while (low < high) {
            while (low < high) {
                if (numbers[high] < soldier) {
                    numbers[low] = numbers[high];
                    break;
                }
                high--;
            }
            while (low < high) {
                if (numbers[low] > soldier) {
                    numbers[high] = numbers[low];
                    break;
                }
                low++;
            }
        }
        numbers[low] = soldier;
        return low;
    }

    @Override
    protected void compute() {

        if (high - low < threshold) {
            QuickSort.qsort(numbers, low, high);
        } else {
            int soldier = partition(numbers, low, high);
            ParallelQuickSort left = new ParallelQuickSort(numbers, low, soldier - 1);
            ParallelQuickSort right = new ParallelQuickSort(numbers, soldier + 1, high);
            invokeAll(left, right);
        }
    }
}

public class MainSort {

    public static void main(String[] args) {
        final int RUN_TIMES = 20;
        final int SORT_NUM = 10000000;
        final int QUICKSORT_THRESHOLD = 36200;

        Long startTime;

        for (int i = 1; i < RUN_TIMES + 1; i++) {

            System.out.println("The " + i + " run:");
            System.out.println("Generating " + SORT_NUM + " numbers");

            Long[] qsNumbers = Utils.getRandomLongNumber(SORT_NUM);
            System.out.println("Excuting QuickSort");
            startTime = System.currentTimeMillis();
            QuickSort.qsort(qsNumbers, 0, qsNumbers.length - 1);
            Long qsRunTime = System.currentTimeMillis() - startTime;
            System.out.println("Total use: " + qsRunTime + " ms");

            Long[] pqsNumbers = Utils.getRandomLongNumber(SORT_NUM);
            System.out.println("Excuting ParallelQuickSort");
            ForkJoinPool pool = new ForkJoinPool();
            ParallelQuickSort parallelQuickSort = new ParallelQuickSort(pqsNumbers, QUICKSORT_THRESHOLD);
            startTime = System.currentTimeMillis();
            pool.execute(parallelQuickSort);
            while (!parallelQuickSort.isDone()) {
            }
            Long pqsRunTime = System.currentTimeMillis() - startTime;
            System.out.println("Total use: " + pqsRunTime + " ms\n");
        }
    }
}