package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
            while(fileReader.ready()){
                String[] numerics = fileReader.readLine().split(" ");
                for(int i=0;i<numerics.length;i++){
                    if (numerics[i].matches("\\d+"))
                    fileWriter.write(numerics[i]+" ");
                }
            }
            fileReader.close();
            fileWriter.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
