package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString() throws IOException {
        return reader.readLine();
    }
    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> list = new ArrayList<>();
        System.out.println("Список всех блюд:");
        System.out.println(Dish.allDishesToString());
        System.out.println("Выберите блюдо.");
        while(true){
            String dishName = ConsoleHelper.readString().trim();
            if(dishName.equals("exit")){
                break;
            }
            try {
                Dish dish = Dish.valueOf(dishName);
                list.add(dish);
                ConsoleHelper.writeMessage("Блюдо "+dishName+" добавлено в заказ.");
            }
            catch (Exception e){
                ConsoleHelper.writeMessage("Такого блюда нет.");
            }
        }
        return list;
    }
}

