package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/
import java.io.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        int s = Integer.parseInt(a);
        if(s<0)
        s++;
        if(s>0)
        s=s*2;
        if(s==0)
        s=s-0;
        System.out.println(s);//напишите тут ваш код

    }

}
