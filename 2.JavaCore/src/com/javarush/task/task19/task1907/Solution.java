package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        try {
            FileReader fileReader = new FileReader(reader.readLine());
            BufferedReader reader1 = new BufferedReader(fileReader);
            while (reader1.ready()) {
                String[] words = reader1.readLine().split("[\\s\\p{P}]");
                for(int i=0;i<words.length;i++){
                    if(words[i].equals("world")) count++;
                }
            }
            System.out.println(count);
            reader.close();
            reader1.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
