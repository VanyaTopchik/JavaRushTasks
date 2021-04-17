package com.javarush.task.task07.task0705;

/* 
Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n[] = new int[20];
        for(int i=0; i<20; i++)
            n[i] = Integer.parseInt(reader.readLine());
        int n1[] = new int[10];
        int n2[] = new int[10];
        for(int i=0; i<10; i++)
            n1[i] = n[i];
        for(int i=0; i<10; i++) {
            n2[i] = n[i+10];
            System.out.println(n2[i]);
        }
    }
}
