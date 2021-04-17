package com.javarush.task.task04.task0416;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String aa = reader.readLine();
        double tt = Double.parseDouble(aa);
        double a = tt % 5;
        if (a>=0 && a<3)
        System.out.println("зелёный");
        if (a>=3 && a<4)
        System.out.println("жёлтый");
        if (a>=4 && a<5)
        System.out.println("красный");
    }
}
                
            
        
    
