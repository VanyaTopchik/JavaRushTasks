package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    String name;
    int age;
    int weight;
    String color;
    String address;
    public void initialize(int weight,String color){
        this.weight = weight;
        this.color = color;
        this.age = 5;
    }
     public void initialize(String name,int weight,int age){
        this.name = name;
        this.weight = weight;
        this.color = "black";
        this.age = age;
    }
     public void initialize(String name,int age){
        this.name = name;
        this.age = age;
    }
     public void initialize(String name){
        this.name = name;
        this.weight = 1;
        this.color = "black";
        this.age = 5;
    }
     public void initialize(int weight,String color,String address){
        this.weight = weight;
        this.color = color;
        this.age = 5;
        this.address = address;
    }//напишите тут ваш код

    public static void main(String[] args) {

    }
}
