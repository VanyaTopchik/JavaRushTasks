package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k;
        int n[] = new int[5];
        int m[] = new int[5];
        for(int i=0; i<5; i++){
            n[i] = Integer.parseInt(reader.readLine());
            m[i]=n[i];
        }
        for(int i=0; i<5; i++) {
            k=0;
            for(int j=0; j<5; j++) {
                if(n[i]>m[j]) {
                    k++;
                }
            }
            m[k]=n[i];
        }
        for(int i=0; i<5; i++) System.out.println(m[i]);
    }
}
