package com.javarush.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask  extends RecursiveTask<String> {
    private final int n;
    public BinaryRepresentationTask(int n) {
        this.n = n;
    }

    @Override
    protected String compute() {
            int a = n % 2;
            int b = n / 2;
            if (b > 0) {
                BinaryRepresentationTask task = new BinaryRepresentationTask(b);
                task.fork();
                return task.join() + a;
            }
            return String.valueOf(a);
        }
}
