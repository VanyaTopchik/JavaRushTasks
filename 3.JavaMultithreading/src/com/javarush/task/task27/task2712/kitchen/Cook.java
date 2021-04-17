package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable {
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public boolean isBusy() {
        return busy;
    }

    private boolean busy;
    private final String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder(Order order) throws InterruptedException {
        busy = true;
        Order order1 = (Order) order;
        setChanged();
        notifyObservers(order);
        ConsoleHelper.writeMessage("Start cooking - " + order);
        CookedOrderEventDataRow row = new CookedOrderEventDataRow(order1.getTablet().toString(), name, order1.getTotalCookingTime() * 60, order1.getDishes());
        StatisticManager.getInstance().register(row);
        Thread.sleep(10 * order.getTotalCookingTime());
        busy = false;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
                if (!queue.isEmpty()) {
                    if (!isBusy()) {
                        startCookingOrder(queue.take());
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
