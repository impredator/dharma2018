package com.dharma.java8.stream;

import java.util.DoubleSummaryStatistics;

public class OperateStat {
    public static void main(String[] args) {
        DoubleSummaryStatistics stats = new DoubleSummaryStatistics();
        stats.accept(100.0);
        stats.accept(300.0);
        stats.accept(230.0);
        stats.accept(532.0);
        stats.accept(422.0);

        long count = stats.getCount();
        double sum = stats.getSum();
        double min = stats.getMin();
        double avg = stats.getAverage();
        double max = stats.getMax();

        System.out.printf(
                "count=%d, sum=%.2f,  min=%.2f,  average=%.2f, max=%.2f%n", count, sum,
                min, max, avg);
    }
}
