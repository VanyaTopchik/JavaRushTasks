package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int i=0,j=0;
        if(anotherCat.weight>this.weight)i++;
        else if(anotherCat.weight<this.weight)j++;
        if(anotherCat.age>this.age)i++;
        else if(anotherCat.age<this.age)j++;
        if(anotherCat.strength>this.strength)i++;
        else if(anotherCat.strength<this.strength)j++;
        if(i<j) return true;
        else if(i>j) return false;
        else return false;//напишите тут ваш код
    }

    public static void main(String[] args) {

    }
}
