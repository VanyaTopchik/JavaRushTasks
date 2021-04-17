package com.javarush.task.task04.task0434;

/*
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        int a = 0;

        while (a<=10)
        {   a++;
            int b = 1;
            while (b<11 && a<=10)
            {
                int g = a*b;
                System.out.print(g + " ");

                b++;
            }
            System.out.println(" ");
        }//напишите тут ваш код

    }
}