package com.learn.items.utils;

public class Printer {

    int startValue = 0;
    int maxRange  = 10;

    public Printer(int startValue, int maxRange){
        this.maxRange = maxRange;
        this.startValue = startValue;
    }

    public Printer() {

    }

    public synchronized void printEven() throws InterruptedException {
        while (startValue <= maxRange) {
            if (startValue % 2 != 0) {
                wait();
            } else {
                System.out.println("Even Number" + startValue);
                System.out.println("ThreadId-Even:"+ Thread.currentThread().getName());
                startValue++;
                notify();
            }
        }
    }

    public synchronized void printOdd() throws InterruptedException {
        while (startValue <= maxRange) {
            if (startValue % 2 == 0) {
                wait();
            } else {
                System.out.println("Odd Number" + startValue);
                System.out.println("ThreadId-Odd:"+ Thread.currentThread().getName());
                startValue++;
                notify();
            }
        }
    }

}
