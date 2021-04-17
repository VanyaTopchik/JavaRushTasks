package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder(){
        Order order = null;
        try {
            order = new Order(this);
            if(order.isEmpty()){
                return null;
            }
            AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
            advertisementManager.processVideos();
            ConsoleHelper.writeMessage(order.toString());
            queue.add(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }catch (NoVideoAvailableException nve) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        return order;
    }
    public void createTestOrder(){
        Order order = null;
        try {
            order = new TestOrder(this);
            AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
            advertisementManager.processVideos();
            ConsoleHelper.writeMessage(order.toString());
            queue.add(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }catch (NoVideoAvailableException nve) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
