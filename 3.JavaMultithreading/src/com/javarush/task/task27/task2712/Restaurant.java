package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> ORDER_QUEUE  = new LinkedBlockingQueue<>();
    public static void main(String[] args) {
        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tablets.add(new Tablet(i + 1));
        }
        Cook cook1 = new Cook("Amigo1");
        cook1.setQueue(ORDER_QUEUE );
        Cook cook2 = new Cook("Amigo2");
        cook2.setQueue(ORDER_QUEUE );
        Thread thread1 = new Thread(cook1);
        Thread thread2 = new Thread(cook2);
        for (int i = 0; i < 5; i++) {
            tablets.get(i).setQueue(ORDER_QUEUE );
        }
        Waiter waiter = new Waiter();
        cook1.addObserver(waiter);
        cook2.addObserver(waiter);
        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets,ORDER_CREATING_INTERVAL));
        thread.start();
        try {
            Thread.sleep(1000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();
    }
}
