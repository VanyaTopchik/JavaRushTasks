package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));
        while(reader1.ready()){
            String str = reader1.readLine().replaceAll("\\p{Punct}", "");
            writer.write(str);
        }
        reader1.close();
        writer.close();
        reader.close();
    }
}
