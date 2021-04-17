package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        while(fileReader.ready()){
            String str = fileReader.readLine();
            for(int i=str.length();i>0; i--){
                System.out.print(str.substring(i-1,i));
            }
            System.out.println("");
        }
        reader.close();
        fileReader.close();
    }
}
