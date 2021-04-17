package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
            while(fileReader.ready()){
                String string = fileReader.readLine().replaceAll("\\.","!");
                fileWriter.write(string);
            }
            fileReader.close();
            fileWriter.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
