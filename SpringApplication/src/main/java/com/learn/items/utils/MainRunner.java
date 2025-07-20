package com.learn.items.utils;

import java.util.concurrent.Callable;

public class MainRunner {

    public static void main(String...args){
        ConcurrencyUtil.printOddEvenUsingThreads();
        ConcurrencyUtil.incrementCounter();
    }
}
