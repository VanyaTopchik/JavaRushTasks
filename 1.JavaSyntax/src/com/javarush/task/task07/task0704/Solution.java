package com.javarush.task.task07.task0704;

/* 
Переверни массив
*/
import java.io.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n[] = new int[10];
        for(int i=0; i<10; i++){
        n[i] = Integer.parseInt(reader.readLine());
        }
        for(int j=0; j<10; j++){
            int a = 9-j;
            System.out.println(n[a]);
        }
    }
}

