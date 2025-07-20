package com.learn.items.pojo;

public class Counter {
    int startingIndex = 0;

    public synchronized void increment(){
        this.startingIndex++;
    }

    public int getStartingIndex() {
        return this.startingIndex;
    }
}
