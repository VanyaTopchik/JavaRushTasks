package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader readNumber1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readNumber2 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readNumber3 = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(readNumber1.readLine());
        int number2 = Integer.parseInt(readNumber2.readLine());
        int number3 = Integer.parseInt(readNumber3.readLine());

        for (int i = 0; i < 3; i++) {
            if (number1 >= number2 && number1 >= number3) {
                System.out.print(number1 + " ");
                number1 = Integer.MIN_VALUE;
            } else if (number2 >= number1 && number2 >= number3) {
                System.out.print(number2 + " ");
                number2 = Integer.MIN_VALUE;
            } else {
                System.out.print(number3 + " ");
                number3 = Integer.MIN_VALUE;
            }
        }
    }
}