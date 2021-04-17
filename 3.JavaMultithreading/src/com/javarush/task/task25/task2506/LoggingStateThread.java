package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{
    private Thread thread;
    public LoggingStateThread(Thread target) {
        super(target);
        this.thread = target;
        thread.setDaemon(true);
    }

    @Override
    public void run() {
        State state, lastState = null;
        while(true) {
            state = thread.getState();
            if (state != lastState) {
                System.out.println(state);
                lastState = state;
            }
            if(state == State.TERMINATED)
                break;
        }
    }
}

