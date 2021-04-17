package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    String name;
    int age;
    int weight;
    String color;
    String address;
    public Cat(int weight,String color){
        this.weight = weight;
        this.color = color;
        this.age = 5;
    }
    public Cat(String name,int weight,int age){
        this.name = name;
        this.weight = weight;
        this.color = "black";
        this.age = age;
    }
    public Cat(String name,int age){
        this.name = name;
        this.age = age;
    }
    public Cat(String name){
        this.name = name;
        this.weight = 1;
        this.color = "black";
        this.age = 5;
    }
    public Cat(int weight,String color,String address){
        this.weight = weight;
        this.color = color;
        this.age = 5;
        this.address = address;
    }//напишите тут ваш код//напишите тут ваш код

    public static void main(String[] args) {

    }
}
