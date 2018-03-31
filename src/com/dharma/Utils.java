package com.dharma;

import java.util.Random;

public class Utils {

    public static Long[] getRandomLongNumber(int n) {

        Random random = new Random();
        Long[] numbers = new Long[n];

        for (int i = 0; i < n; i++) {
            Long num = random.nextLong();
            if (num < 0) {
                num = Math.abs(num);
            }
            numbers[i] = num;
        }
        return numbers;
    }
}