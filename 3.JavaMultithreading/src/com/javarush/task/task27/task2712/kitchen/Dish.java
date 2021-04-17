package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    FISH(25),
    STEAK(30),
    SOUP(15),
    JUICE(5),
    WATER(3);
    public static String allDishesToString(){
        StringBuilder menu = new StringBuilder("");
        for(Dish dish:Dish.values()){
            if((menu.toString()).equals(""))
            menu.append(dish.name());
            else menu.append(" ,"+dish.name());
        }
        return menu.toString();
    }
    private int duration;
    public int getDuration() {
        return duration;
    }

    Dish(int duration) {
        this.duration = duration;
    }
}