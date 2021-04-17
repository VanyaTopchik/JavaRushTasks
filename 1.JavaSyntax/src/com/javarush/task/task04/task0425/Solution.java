package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/
import java.io.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        int a = Integer.parseInt(s1);
        String s2 = reader.readLine();
        int b = Integer.parseInt(s2);//напишите тут ваш код
        if(a>0&&b>0)
        System.out.print(1);
        if(a>0&&b<0)
        System.out.print(4);
        if(a<0&&b>0)
        System.out.print(2);
        if(a<0&&b<0)
        System.out.print(3);
    }
}
