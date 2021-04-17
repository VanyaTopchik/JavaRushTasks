package com.javarush.task.task03.task0312;

/* 
Конвертируем время
*/

public class Solution {
    public static int convertToSeconds(int hour) {
        int b = hour*60*60;
        return b;
    }
    //напишите тут ваш код

    public static void main(String[] args) {
        int a = 5;//напишите тут ваш код
        int z = convertToSeconds(a);
        System.out.println(z);
        a = 8;//напишите тут ваш код
        z = convertToSeconds(a);
        System.out.println(z);
    }
}
