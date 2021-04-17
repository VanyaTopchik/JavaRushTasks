package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import org.w3c.dom.events.Event;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public List<Dish> getDishes() {
        return dishes;
    }

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    @Override
    public String toString() {
        if(dishes.isEmpty()){
            return "";
        }
        return "Your order: " + dishes + " of " + tablet.toString()+", cooking time "+getTotalCookingTime()+"min";
    }
    public int getTotalCookingTime(){
        int result=0;
        for(Dish dish:dishes){
            result+=dish.getDuration();
        }
        return result;
    }
    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public Tablet getTablet() {
        return tablet;
    }
    protected void initDishes() throws IOException {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }
}
