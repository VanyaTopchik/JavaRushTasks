package com.javarush.task.task04.task0424;

/* 
Три числа
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
        if(a==c&&b!=a)
        System.out.print(2);
         if(a==b&&c!=a)
        System.out.print(3);
         if(b==c&&a!=b)
        System.out.print(1);//напишите тут ваш код

    }
}
