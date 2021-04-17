package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
       double dollar = convertEurToUsd(50,76.54);
       System.out.println(dollar);//напишите тут ваш код
       dollar = convertEurToUsd(40,74.84);
       System.out.println(dollar);
    }

    public static double convertEurToUsd(int eur, double course) {
        double a;
        a = eur*course;
        return a;//напишите тут ваш код

    }
}
