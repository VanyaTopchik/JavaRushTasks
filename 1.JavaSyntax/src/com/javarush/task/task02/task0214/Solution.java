package com.javarush.task.task02.task0214;

/* 
Минимум двух чисел
*/
public class Solution {
    public static int min(int a, int b) {
        int c;
        if(a < b)
        c=a;
        else
        c=b;
        return c;//напишите тут ваш код
    }

    public static void main(String[] args) {
        System.out.println(min(12, 33));
        System.out.println(min(-20, 0));
        System.out.println(min(-10, -20));
    }
}