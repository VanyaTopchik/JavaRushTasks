package com.javarush.task.task27.task2711;

import java.util.concurrent.CountDownLatch;

/* 
CountDownLatch
*/
public class Solution {
    private volatile boolean isWaitingForValue = true;

    CountDownLatch latch = new CountDownLatch(1);

    public void someMethod() throws InterruptedException {
        latch.await();
        retrieveValue();
        isWaitingForValue = false;
    }

    void retrieveValue() {
        System.out.println("Value retrieved.");
        latch.countDown();
    }

    public static void main(String[] args) {

    }
}
