package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        int a = Integer.parseInt(s1);
        String s2 = reader.readLine();
        int b = Integer.parseInt(s2);
        String s3 = reader.readLine();
        int c = Integer.parseInt(s3);
        if(a+b>c&&a+c>b&&b+c>a)
        System.out.println("Треугольник существует.");
        else
        System.out.println("Треугольник не существует.");//напишите тут ваш код

    }
}