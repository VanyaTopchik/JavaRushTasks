package com.javarush.task.task05.task0532;

/* 
Задача по алгоритмам
Написать программу, которая:
1. считывает с консоли число N, которое должно быть больше 0
2. потом считывает N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.


Требования:
1. Программа должна считывать числа с клавиатуры.
2. Программа должна выводить число на экран.
3. В классе должен быть метод public static void main.
4. Нельзя добавлять новые методы в класс Solution.
5. Программа должна выводить на экран максимальное из введенных N чисел.
6. Программа не должна ничего выводить на экран, если N меньше либо равно 0.
*/
import java.io.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int maximum = 0;
        if(N>0) {
            int k[] = new int[N];
            for (int i = 0; i < N; i++) {
                k[i] = Integer.parseInt(reader.readLine());
                }
            maximum = k[0];
            for (int i = 0; i < N; i++) {
                if(k[i]>maximum) maximum = k[i];
            }

            System.out.println(maximum);
        }
    }
}
