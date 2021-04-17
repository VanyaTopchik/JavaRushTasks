package com.javarush.task.task07.task0701;

import java.io.IOException;
import java.io.*;
/* 
Массивный максимум
1. В методе initializeArray():
1.1. Создайте массив на 20 чисел
1.2. Считайте с консоли 20 чисел и заполните ими массив
2. Метод max(int[] array) должен находить максимальное число из элементов массива


*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] n = new int[20];
        for(int i=0; i<20; i++){
             n[i] = Integer.parseInt(reader.readLine());
        }
        return n;
    }

    public static int max(int[] array) {
        int max = array[0];
        for(int i=0; i<20; i++)
            if(array[i]>max) max=array[i];
        return max;
    }
}
