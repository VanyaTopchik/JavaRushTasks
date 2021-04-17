package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable{
    private ConcurrentHashMap<String, String> map;
    private int value=1;
    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }
    @Override
    public void run() {
        try {
            while (true) {
                map.put(Integer.toString(++value), ("Some text for " + value));
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("[" + this.getClass().getName() + "] thread was terminated");
        }
    }
}
