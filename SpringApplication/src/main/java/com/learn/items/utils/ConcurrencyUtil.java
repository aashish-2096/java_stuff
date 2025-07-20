package com.learn.items.utils;

import com.learn.items.pojo.Counter;

public class ConcurrencyUtil {
    /**
     * Odd Even Using Threads
     */
    public static void printOddEvenUsingThreads() {
        Printer printer = new Printer(0, 10);
        Thread thread1 = new Thread(() -> {
            try {
                printer.printEven();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                printer.printOdd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread2.start();
        thread1.start();
    }

    public static void incrementCounter(){
        Counter count = new Counter();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) count.increment();
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Total Counter Value:-"+count.getStartingIndex());
    }
}
