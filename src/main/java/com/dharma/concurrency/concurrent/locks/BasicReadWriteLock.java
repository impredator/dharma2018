package com.dharma.concurrency.concurrent.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.Thread.sleep;

public class BasicReadWriteLock {

    private static Map<String, String> syncHashMap = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
    private Integer counter = 0;

    public void put(String key, String value) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "acquiring lock");
        try {
            writeLock.lock();
            System.out.println(Thread.currentThread().getName() + "locked");
            syncHashMap.put(key, value);
            System.out.println(counter++);
            sleep(1000);
        } finally {
            writeLock.unlock();
        }

    }

    public String get(String key) {
        try {
            readLock.lock();
            return syncHashMap.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public String remove(String key) {
        try {
            writeLock.lock();
            return syncHashMap.remove(key);
        } finally {
            writeLock.unlock();
        }
    }

    public boolean containsKey(String key) {
        try {
            readLock.lock();
            return syncHashMap.containsKey(key);
        } finally {
            readLock.unlock();
        }
    }

    boolean isReadLockAvailable() {
        return readLock.tryLock();
    }

    public static void main(String[] args) throws InterruptedException {

        final int threadCount = 4;
        final ExecutorService service = Executors.newFixedThreadPool(threadCount);
        BasicReadWriteLock object = new BasicReadWriteLock();

        service.execute(new Thread(new Writer(object), "Writer1"));
        service.execute(new Thread(new Reader(object), "Reader1"));
        service.execute(new Thread(new Reader(object), "Reader2"));
        service.execute(new Thread(new Writer(object), "Writer2"));

        service.shutdown();
    }

    private static class Reader implements Runnable {

        BasicReadWriteLock object;

        Reader(BasicReadWriteLock object) {
            this.object = object;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " reading...");
                System.out.println(i);
            }
        }
    }

    private static class Writer implements Runnable {

        BasicReadWriteLock object;

        Writer(BasicReadWriteLock object) {
            this.object = object;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    object.put("key" + i, "value" + i);
                    System.out.println(Thread.currentThread().getName() + " writing...");
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
