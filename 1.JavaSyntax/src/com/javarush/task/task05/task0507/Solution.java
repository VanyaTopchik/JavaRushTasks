package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/
import java.io.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double count = 0;
        double sum = 0;
        while(true){
        int n = Integer.parseInt(reader.readLine());
        if(n==-1)break;
        else{sum += n;
        count++;}
        }
        System.out.print(sum/count);//напишите тут ваш код
    }
}

